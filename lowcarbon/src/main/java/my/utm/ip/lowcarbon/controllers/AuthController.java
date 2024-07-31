package my.utm.ip.lowcarbon.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.utm.ip.lowcarbon.models.user.User;
import my.utm.ip.lowcarbon.models.user.userRepo.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/")
    public String viewParticipantLoginForm(Model model) {
        return "auth/login";
    }
    
    @RequestMapping("/registerForm")
    public String viewRegisterForm(Model model) {
        return "auth/register";
    }

    @PostMapping("/login")
    public String authoriseLogin(
        @RequestParam String email, 
        @RequestParam String password,
        HttpSession session,
        RedirectAttributes redirectAttributes
    ) {
        User user = userRepo.getUserByEmail(email);
        
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("userEmail", user.getEmail());
            session.setAttribute("userId", user.getUser_id());
            String role = user.getRole();
            session.setAttribute("role", role);
            return "redirect:/home";
        } else {
            // Handle invalid login credentials, you can set an error message
            redirectAttributes.addFlashAttribute("error", "Invalid credentials");
            return "redirect:/";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @PostMapping("/register")
    public String registerAccount(
        @RequestParam String role,
        @RequestParam String email, 
        @RequestParam String password,
        @RequestParam String fname,
        @RequestParam String phone,
        @RequestParam String address,
        @RequestParam String category,
        RedirectAttributes redirectAttributes
    ) {

        User user = new User();

        user.setRole("participant");
        user.setFullName(fname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phone);
        user.setAddress(address);
        user.setCategory(category);

        userRepo.createUser(user);
        return "redirect:/";
    }

    @RequestMapping("/userList")
    public String showWaterUsageData(Model model, HttpSession session) {
        List<User> userList = userRepo.getAllUser();
        List<User> userA1 = new ArrayList<>();
        List<User> userA2 = new ArrayList<>();
        List<User> userB1 = new ArrayList<>();
        List<User> userB2 = new ArrayList<>();
        
        for(User user: userList){
            String category = user.getCategory();
            switch (category) {
                case "A1":
                    userA1.add(user);
                    break;
                case "A2":
                    userA2.add(user);
                    break;
                case "B1":
                    userB1.add(user);
                    break;
                case "B2":
                    userB2.add(user);
                    break;
                default:
                    break;
            }
        }
        model.addAttribute("userA1", userA1);
        model.addAttribute("userA2", userA2);
        model.addAttribute("userB1", userB1);
        model.addAttribute("userB2", userB2);
        return "auth/userList";
    }

    @RequestMapping("/deleteParticipant")
    public String deleteWater(@RequestParam String participantId){
        userRepo.deleteParticipant(participantId);
        return "redirect:/userList";
    }
}
