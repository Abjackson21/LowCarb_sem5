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

import my.utm.ip.lowcarbon.models.water.Water;
import my.utm.ip.lowcarbon.services.monthlyUpdate.waterService.WaterService;

@Controller

public class WaterController {

    @Autowired
    private WaterService waterService;

    @RequestMapping("/waterList")
    public String showWaterUsageData(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String role = (String) session.getAttribute("role");
        model.addAttribute("role", role);

        if(role.equals("admin")){
            List<Water> waterUsageList = waterService.getAllWater();
            int[] month ={1,2,3,4,5,6};
            List<Water> jan = new ArrayList<>();
            List<Water> feb = new ArrayList<>();
            List<Water> march = new ArrayList<>();
            List<Water> april = new ArrayList<>();
            List<Water> may = new ArrayList<>();
            List<Water> jun = new ArrayList<>();
            
            for(Water water: waterUsageList){
                int monthWater = water.getMonth();
                switch (monthWater) {
                    case 1:
                        jan.add(water);
                        break;
                    case 2:
                        feb.add(water);
                        break;
                    case 3:
                        march.add(water);
                        break;
                    case 4:
                        april.add(water);
                        break;
                    case 5:
                        may.add(water);
                        break;
                    case 6:
                        jun.add(water);
                        break;
                    default:
                        break;
                }
                
            }

            List<Water> waterMonthList = new ArrayList<>();
            waterMonthList.addAll(jan);
            waterMonthList.addAll(feb);
            waterMonthList.addAll(march);
            waterMonthList.addAll(april);
            waterMonthList.addAll(may);
            waterMonthList.addAll(jun);

            model.addAttribute("months", month);
            model.addAttribute("waterMonthList", waterMonthList);
            return "carbon/water/waterListAdmin";
         } else{
            List<Water> waterUsageList = waterService.getAllWaterByUserId(userId);
            model.addAttribute("waterUsageList", waterUsageList);
            return "carbon/water/waterList";
         }
    }

    @RequestMapping("/formAddWater")
    public String viewAddWaterForm(Model model) {
        model.addAttribute("mode", "add");
        model.addAttribute("water", new Water());
        return "carbon/water/waterForm";
    }

    @RequestMapping("/addWater")
    public String addWater(
        @RequestParam("month") int month,
        @RequestParam("numday") int numday,
        @RequestParam("profacta") double profacta,
        @RequestParam("usagem3") double usagem3,
        @RequestParam("usagem3RM") double usagem3RM, 
        HttpSession session, RedirectAttributes redirectAttributes) {

            String userId = (String) session.getAttribute("userId");
            Water water = new Water(userId, month, numday, profacta, usagem3, usagem3RM);
            try {
                waterService.addWaterUsage(water);
                return "redirect:/waterList";
            } catch (RuntimeException e) {
                redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
                return "redirect:/waterList"; // Return to the same page
            }
    }

    @RequestMapping("/formEditWater")
    public String viewEditWaterForm(@RequestParam int month, Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        Water water = waterService.getWaterByMonth(userId, month);
        model.addAttribute("mode", "edit");
        model.addAttribute("water", water);
        return "carbon/water/waterForm";
    }

    @RequestMapping("/editWater")
    public String editWater(
            @RequestParam("month") int month,
            @RequestParam("numday") int numday,
            @RequestParam("profacta") double profacta,
            @RequestParam("usagem3") double usagem3,
            @RequestParam("usagem3RM") double usagem3RM,
            HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        Water water = new Water(userId, month, numday, profacta, usagem3, usagem3RM);
        waterService.updateWaterUsage(water);
        return "redirect:/waterList";
    }

    @RequestMapping("/deleteWater")
    public String deleteWater(@RequestParam int month, HttpSession session){
        String userId = (String) session.getAttribute("userId");
        waterService.deleteWaterUsage(userId, month);
        return "redirect:/waterList";
    }
}
