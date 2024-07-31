package my.utm.ip.lowcarbon.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.utm.ip.lowcarbon.models.user.User;
import my.utm.ip.lowcarbon.models.user.userRepo.UserRepository;

@Controller
public class profileController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/profileView")
    public String profileView(Model model, HttpSession session) {
        String email = (String) session.getAttribute("userEmail");
        User user = userRepo.getUserByEmail(email);
        model.addAttribute("user", user);
        return "profile/profileView";
    }

    @RequestMapping("/profileUpdateForm")
    public String displayUpdateForm(Model model, HttpSession session) {
        String email = (String) session.getAttribute("userEmail");
        User user = userRepo.getUserByEmail(email);
        model.addAttribute("user", user);
        return "profile/profileUpdate";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam String address, @RequestParam String phone,HttpSession session, RedirectAttributes redirectAttributes){
        String email = (String) session.getAttribute("userEmail");
        User user = userRepo.getUserByEmail(email);
        user.setAddress(address);
        user.setPhoneNumber(phone);
        userRepo.updateUser(user);
        return "redirect:/profileView";
    }
}
