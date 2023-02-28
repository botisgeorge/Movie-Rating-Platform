package moviePlatform.Controllers;

import jakarta.transaction.Transactional;
import moviePlatform.DAO.CommentRepository;
import moviePlatform.DAO.MovieRepository;
import moviePlatform.Entities.Comment;
import moviePlatform.Entities.Movie;
import moviePlatform.Entities.User;
import moviePlatform.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/api/v1")
public class HomeResource {
    public User User;

    @GetMapping("/home")
    public String homePage(Model model) {
        if (User != null)
        {
            model.addAttribute("username", User.getUsername());
        }
        return "home.html";
    }


    @GetMapping("/user={name}")
    public String getUser(@PathVariable String name, Model model) {
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        return "user";
    }
    @GetMapping("movie={name}")
    public String getMovie(@PathVariable String name, Model model) {
        Movie movie = movieRepository.findByName(name);
        model.addAttribute("movie",movie);
        Iterable<Comment> commentIterable = commentRepository.findAll();
        List<Comment> comments = StreamSupport.stream(commentIterable.spliterator(), false).collect(Collectors.toList());
        model.addAttribute("comments",comments);
        if(User!=null)
            return "movie";
        else
            return "movieNOCOMS";
    }

    @GetMapping("/register")
    public String register() {
        return "register.html";
    }

    @PostMapping("/register")
    public String createUser(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("gender") String gender,
                             @RequestParam("location") String location,
                             @RequestParam("description") String description,
                             @RequestParam("profilePhoto") String profilePhoto
    ) {
        User newUser = new User(0,username,password,"User",gender,location,description,profilePhoto);
        System.out.println(newUser.getId());
        userRepository.save(newUser);
        User=newUser;
        return "redirect:/api/v1/home";
    }

    @GetMapping("userdelete={username}")
    public String deleteUser(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        userRepository.delete(user);
        return "redirect:/api/v1/adminEdit";
    }

    @GetMapping("delete={name}")
    public String deleteMovie(@PathVariable String name) {
        Movie movie = movieRepository.findByName(name);
        movieRepository.delete(movie);
        return "redirect:/api/v1/adminEdit";
    }

    @GetMapping("/movie={name}/comment")
    public String commentPage(@PathVariable String name, Model model) {
        model.addAttribute("movieName", name);
        return "commentPage";
    }

    @PostMapping("/movie={name}/comment")
    public String createComment(@PathVariable String name, @RequestParam("comment") String commentText, Model model) {
        Movie movie = movieRepository.findByName(name);
        int userId = User.getId();
        Comment comment = new Comment(userId, "name", commentText);
        System.out.println(comment.getComment() + " " + comment.getId()  + " " +  comment.getNumeFilm()  + " " + comment.getUserId());
        commentRepository.save(comment);
        return "redirect:/api/v1/home";
    }

        @RequestMapping("/login")
        public String login() {
            return "login.html";
        }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/admin")
    public String adminPage() {
        if(isAdmin())
            return "admin.html";
        else
            return "login.html";
    }

    @GetMapping("/adminEdit")
    public String editPage(Model model) {
        Iterable<Movie> iterableMovies = movieRepository.findAll();
        List<Movie> movies = StreamSupport.stream(iterableMovies.spliterator(), false).collect(Collectors.toList());
        model.addAttribute("movies", movies);
        return "adminEditDelete.html";
    }

    @GetMapping("/adminDeleteUsers")
    public String showUsers(Model model) {
        Iterable<User> userIterable = userRepository.findAll();
        List<User> users = StreamSupport.stream(userIterable.spliterator(), false).collect(Collectors.toList());
        model.addAttribute("users",users);
        System.out.println(users);
        return "deleteUsers.html";
    }



    @PostMapping("/admin")
    public String admin(@RequestParam("name") String name,
                        @RequestParam("type") String type,
                        @RequestParam("episodes") int episodes,
                        @RequestParam("status") String status,
                        @RequestParam("aired") String aired,
                        @RequestParam("premiered") String premiered,
                        @RequestParam("producers") String producers,
                        @RequestParam("licensors") String licensors,
                        @RequestParam("studio") String studio,
                        @RequestParam("genres") String genres,
                        @RequestParam("theme") String theme,
                        @RequestParam("demographic") String demographic,
                        @RequestParam("duration") String duration,
                        @RequestParam("description") String description,
                        @RequestParam("photo") String photo) {
        Movie movie = new Movie(1,name,type,episodes,status,aired,premiered,producers,licensors,studio,genres,theme,demographic,duration,description,0,photo);
        System.out.println(movie);
        movieRepository.save(movie);
        return "redirect:/api/v1/adminEdit";
    }

    @GetMapping("/edit={name}")
    public String editMovie(@PathVariable String name, Model model) {
        Movie movie = movieRepository.findByName(name);
        model.addAttribute("movie", movie);
        return "movieEdit.html";
    }

    @PostMapping("/edit={name}")
    public String updateMovie(@RequestParam String name, @RequestParam String type,
                              @RequestParam int episodes,@RequestParam String status,@RequestParam String aired,
                              @RequestParam String premiered,@RequestParam String producers,@RequestParam String licensors,
                              @RequestParam String studio,@RequestParam String genres,@RequestParam String theme,
                              @RequestParam String demographic,@RequestParam String duration,@RequestParam String photo,
                              @RequestParam String description) {
        Movie movie = movieRepository.findByName(name);
        movie.setType(type);
        movie.setEpisodes(episodes);
        movie.setStatus(status);
        movie.setAired(aired);
        movie.setPremiered(premiered);
        movie.setProducers(producers);
        movie.setLicensors(licensors);
        movie.setStudios(studio);
        movie.setGenres(genres);
        movie.setTheme(theme);
        movie.setDemographic(demographic);
        movie.setDuration(duration);
        movie.setPhoto(photo);
        movie.setDescription(description);
        movieRepository.save(movie);
        return "redirect:/api/v1/adminEdit";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            // User found and password is correct, redirect to home page
            User=foundUser;
            if(isAdmin())
            {
                return "redirect:/api/v1/adminEdit";
            }
            else
            {
                return "redirect:/api/v1/home";
            }
        } else {
            // User not found or password is incorrect, show error message
            return "redirect:/api/v1/login";
        }
    }

    public boolean validUser() {
        if (User.getId()!=-1)
            return true;
        return false;
    }

    public boolean isAdmin() {
        if(User.getRole().equals("Admin"))
            return true;
        return false;
    }

}
