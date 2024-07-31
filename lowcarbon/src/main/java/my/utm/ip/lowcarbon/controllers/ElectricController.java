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

import my.utm.ip.lowcarbon.models.electric.Electric;
import my.utm.ip.lowcarbon.models.electric.electricRepo.ElectricRepository;


@Controller
public class ElectricController {

    @Autowired
    private ElectricRepository electricRepo;

    @RequestMapping("/electricList")
    public String showElectricUsageData(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String role =(String) session.getAttribute("role");
        model.addAttribute("role", role);

        if(role.equals("admin")){
            List<Electric> electricUsageList = electricRepo.getAllElectric();
            int[] month ={1,2,3,4,5,6};
            List<Electric> jan = new ArrayList<>();
            List<Electric> feb = new ArrayList<>();
            List<Electric> march = new ArrayList<>();
            List<Electric> april = new ArrayList<>();
            List<Electric> may = new ArrayList<>();
            List<Electric> jun = new ArrayList<>();
            
            for(Electric electric: electricUsageList){
                int monthElectric = electric.getElectric_month();
                switch (monthElectric) {
                    case 1:
                        jan.add(electric);
                        break;
                    case 2:
                        feb.add(electric);
                        break;
                    case 3:
                        march.add(electric);
                        break;
                    case 4:
                        april.add(electric);
                        break;
                    case 5:
                        may.add(electric);
                        break;
                    case 6:
                        jun.add(electric);
                        break;
                    default:
                        break;
                }
                
            }

            List<Electric> electricMonthList = new ArrayList<>();
            electricMonthList.addAll(jan);
            electricMonthList.addAll(feb);
            electricMonthList.addAll(march);
            electricMonthList.addAll(april);
            electricMonthList.addAll(may);
            electricMonthList.addAll(jun);

            model.addAttribute("months", month);
            model.addAttribute("electricMonthList", electricMonthList);
            return "carbon/electric/electricListAdmin";
         } else{
            List<Electric> electricUsageList = electricRepo.getAllElectricByUserId(userId);
            model.addAttribute("electricUsageList", electricUsageList);
            return "carbon/electric/electricList";
         }
    }

    @RequestMapping("/formAddElectric")
    public String viewAddElectricForm(Model model) {
        model.addAttribute("mode", "add");
        model.addAttribute("electric", new Electric());
        return "carbon/electric/electricForm";
    }

    @RequestMapping("/addElectric")
    public String addElectric(
        @RequestParam("month") int month,
        @RequestParam("numday") int numday,
        @RequestParam("profacta") double profacta,
        @RequestParam("usagekWh") double usagekWh,
        @RequestParam("usagekWhRM") double usagekWhRM, 
        HttpSession session, RedirectAttributes redirectAttributes) {

            String userId = (String) session.getAttribute("userId");
            Electric Electric = new Electric(month, numday, profacta, usagekWh, usagekWhRM, userId);
            try {
                electricRepo.addElectricUsage(Electric);
                return "redirect:/electricList";
            } catch (RuntimeException e) {
                redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
                return "redirect:/electricList"; // Return to the same page
            }
    }

    @RequestMapping("/formEditElectric")
    public String viewEditElectricForm(@RequestParam int month, Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        Electric electric = electricRepo.getElectricByMonth(userId, month);
        model.addAttribute("mode", "edit");
        model.addAttribute("electric", electric);
        return "carbon/electric/electricForm";
    }

    @RequestMapping("/editElectric")
    public String editElectric(
            @RequestParam("month") int month,
            @RequestParam("numday") int numday,
            @RequestParam("profacta") double profacta,
            @RequestParam("usagekWh") double usagekWh,
            @RequestParam("usagekWhRM") double usagekWhRM, 
            HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        Electric electric = new Electric(month, numday, profacta, usagekWh, usagekWhRM, userId);
        electricRepo.updateElectricUsage(electric);
        return "redirect:/electricList";
    }

    @RequestMapping("/deleteElectric")
    public String deleteElectric(@RequestParam int month, HttpSession session){
        String userId = (String) session.getAttribute("userId");
        electricRepo.deleteElectricUsage(userId, month);
        return "redirect:/electricList";
    }
}
