package wk.pl.zadanie26.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @PostMapping("/save")
    String save(User user) {
        userRepository.save(user);
        return "redirect:/";
    }

}
