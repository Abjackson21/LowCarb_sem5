package my.utm.ip.lowcarbon.controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import my.utm.ip.lowcarbon.models.calculate.Calculate;
import my.utm.ip.lowcarbon.models.electric.Electric;
import my.utm.ip.lowcarbon.models.electric.electricRepo.ElectricRepository;
import my.utm.ip.lowcarbon.models.recycle.Recycle;
import my.utm.ip.lowcarbon.models.recycle.recycleRepo.RecycleRepository;
import my.utm.ip.lowcarbon.models.user.User;
import my.utm.ip.lowcarbon.models.user.userRepo.UserRepository;
import my.utm.ip.lowcarbon.models.water.Water;
import my.utm.ip.lowcarbon.services.monthlyUpdate.waterService.WaterService;


@Controller
public class CalaculateController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private WaterService waterService;
    @Autowired
    private ElectricRepository electricRepo;
    @Autowired
    private RecycleRepository recycleRepo;

    @RequestMapping("/home")
    public String home(Model model, HttpSession session) {
        String role = (String) session.getAttribute("role");
        String userId = (String) session.getAttribute("userId");
        model.addAttribute("role", role);

        List<User> userList = new ArrayList<>();
        List<Water> waterList = new ArrayList<>();
        List<Electric> electricList = new ArrayList<>();
        List<Recycle> recycleList = new ArrayList<>();

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        int numParticipant=0;
        double totalEmission = 0;
        double waterEmission = 0;
        double electrictEmission = 0;
        double recycleEmission = 0;

        if(role.equals("admin")){
            userList = userRepo.getAllUser();
            waterList = waterService.getAllWater();
            electricList = electricRepo.getAllElectric();
            recycleList = recycleRepo.getAllRecycle();
        } else{
            waterList = waterService.getAllWaterByUserId(userId);
            electricList = electricRepo.getAllElectricByUserId(userId);
            recycleList = recycleRepo.getAllRecycleByUserId(userId);
        }
       
        numParticipant= userList.size();
        for(User checkAdmin: userList){
            if(checkAdmin.getRole().equals("admin")){
                numParticipant -= 1;
            }
        }

        for(Water water: waterList){
            double waterCarbon = water.getUsagem3() * 0.419;
            waterEmission += waterCarbon;
        }

        for(Electric electric: electricList){
            double electricCarbon = electric.getElectric_usagekWh()* 0.584;
            electrictEmission += electricCarbon;
        }

        for(Recycle recycle: recycleList){
            double recycleCarbon = recycle.getCollectedKG()* 2.860;
            recycleEmission += recycleCarbon;
        }

        totalEmission = waterEmission +  electrictEmission + recycleEmission;
        Calculate calculate = new Calculate(totalEmission, waterEmission, electrictEmission, recycleEmission);

        String total_emission = numberFormat.format(totalEmission);
        String water_emission = numberFormat.format(waterEmission);
        String electric_emission = numberFormat.format(electrictEmission);
        String recycle_emission = numberFormat.format(recycleEmission);
        model.addAttribute("numParticipant", numParticipant);
        model.addAttribute("calculate", calculate);
        model.addAttribute("total_emission", total_emission);
        model.addAttribute("water_emission", water_emission);
        model.addAttribute("electric_emission", electric_emission);
        model.addAttribute("recycle_emission", recycle_emission);
        return "home/home";
    }
}
