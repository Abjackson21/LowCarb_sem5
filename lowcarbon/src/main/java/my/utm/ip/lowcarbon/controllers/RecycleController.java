package my.utm.ip.lowcarbon.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.utm.ip.lowcarbon.models.recycle.Recycle;
import my.utm.ip.lowcarbon.models.recycle.recycleRepo.RecycleRepository;
import my.utm.ip.lowcarbon.models.user.User;
import my.utm.ip.lowcarbon.models.user.userRepo.UserRepository;

@Controller
public class RecycleController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RecycleRepository recycleRepo;

    @RequestMapping("/recycleList")
    public String showRecycleUsageData(Model model, HttpSession session) {
        String email = (String) session.getAttribute("userEmail");
        User user = userRepo.getUserByEmail(email);
        String role = user.getRole();
        model.addAttribute("user", user);
        model.addAttribute("role", role);

        if(role.equals("admin")){
            List<Recycle> recycleActivityList = recycleRepo.getAllRecycle();
            int[] month ={1,2,3,4,5,6};
            List<Recycle> jan = new ArrayList<>();
            List<Recycle> feb = new ArrayList<>();
            List<Recycle> march = new ArrayList<>();
            List<Recycle> april = new ArrayList<>();
            List<Recycle> may = new ArrayList<>();
            List<Recycle> jun = new ArrayList<>();
            
            for(Recycle recycle: recycleActivityList){
                int monthRecycle = recycle.getRecycle_month();
                switch (monthRecycle) {
                    case 1:
                        jan.add(recycle);
                        break;
                    case 2:
                        feb.add(recycle);
                        break;
                    case 3:
                        march.add(recycle);
                        break;
                    case 4:
                        april.add(recycle);
                        break;
                    case 5:
                        may.add(recycle);
                        break;
                    case 6:
                        jun.add(recycle);
                        break;
                    default:
                        break;
                }
                
            }

            List<Recycle> recycleMonthList = new ArrayList<>();
            recycleMonthList.addAll(jan);
            recycleMonthList.addAll(feb);
            recycleMonthList.addAll(march);
            recycleMonthList.addAll(april);
            recycleMonthList.addAll(may);
            recycleMonthList.addAll(jun);

            model.addAttribute("months", month);
            model.addAttribute("recycleMonthList", recycleMonthList);
            return "carbon/recycle/recycleListAdmin";
         } else{
            List<Recycle> recycleUsageList = recycleRepo.getAllRecycleByUserId(user.getUser_id());
            model.addAttribute("recycleUsageList", recycleUsageList);
            return "carbon/recycle/recycleList";
         }
    }

    @RequestMapping("/formAddRecycle")
    public String viewAddRecycleForm(Model model) {
        model.addAttribute("mode", "add");
        model.addAttribute("recycle", new Recycle());
        return "carbon/recycle/recycleForm";
    }

    @RequestMapping("/addRecycle")
    public String addRecycle(
        @RequestParam("month") int month,
        @RequestParam("collectedKG") double collectedKG,
        @RequestParam("collectedRM") double collectedRM, 
        HttpSession session, RedirectAttributes redirectAttributes) {

            String userId = (String) session.getAttribute("userId");
            Recycle recycle = new Recycle(month, collectedKG, collectedRM, userId);
            try {
                recycleRepo.addRecycleActivity(recycle);
                return "redirect:/recycleList";
            } catch (RuntimeException e) {
                redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
                return "redirect:/recycleList"; // Return to the same page
            }
    }

    @RequestMapping("/formEditRecycle")
    public String viewEditRecycleForm(@RequestParam int month, Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        Recycle recycle = recycleRepo.getRecycleByMonth(userId, month);
        model.addAttribute("mode", "edit");
        model.addAttribute("recycle", recycle);
        return "carbon/recycle/recycleForm";
    }

    @RequestMapping("/editRecycle")
    public String editRecycle(
        @RequestParam("month") int month,
        @RequestParam("collectedKG") double collectedKG,
        @RequestParam("collectedRM") double collectedRM, 
        HttpSession session) {
            String userId = (String) session.getAttribute("userId");
            Recycle recycle = new Recycle(month, collectedKG, collectedRM, userId);
            recycleRepo.updateRecycleActivity(recycle);
            return "redirect:/recycleList";
    }

    @RequestMapping("/deleteRecycle")
    public String deleteRecycle(@RequestParam int month, HttpSession session){
        String userId = (String) session.getAttribute("userId");
        recycleRepo.deleteRecycleActivity(userId, month);
        return "redirect:/recycleList";
    }
}
