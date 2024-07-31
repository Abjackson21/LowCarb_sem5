package my.utm.ip.lowcarbon.services.monthlyUpdate.waterService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.lowcarbon.models.water.Water;
import my.utm.ip.lowcarbon.models.water.WaterDAO;
import my.utm.ip.lowcarbon.models.water.waterRepo.WaterRepository;

public class WaterService_DB implements WaterService {
    
    @Autowired
    WaterRepository waterRepo;

    @Override
    public List<Water> getAllWater() {
        List<WaterDAO> daos = new ArrayList<>();
        daos = waterRepo.getAllWater();
        
        List<Water> waters = new ArrayList<>();

        for(WaterDAO dao: daos){
            Water water = new Water(dao);
            waters.add(water);
        }
        return waters;
    }

    @Override
    public List<Water> getAllWaterByUserId(String user_id) {
        List<WaterDAO> daos = new ArrayList<>();
        
        daos = waterRepo.getAllWaterByUserId(user_id);
        
        List<Water> waters = new ArrayList<>();

        for(WaterDAO dao: daos){
            Water water = new Water(dao);
            waters.add(water);
        }
        return waters;
    }

    @Override
    public Water addWaterUsage(Water water) {
        WaterDAO dao = waterRepo.addWaterUsage(water.toDAO());
        return new Water(dao);
    }

    @Override
    public Water updateWaterUsage(Water water) {
        WaterDAO dao = waterRepo.updateWaterUsage(water.toDAO());
        return new Water(dao);
    }

    @Override
    public Water getWaterByMonth(String user_id, int month) {
        WaterDAO dao = waterRepo.getWaterByMonth(user_id, month);
        Water water = new Water(dao);

        return water;
    }

    @Override
    public void deleteWaterUsage(String user_id, int month) {
        waterRepo.deleteWaterUsage(user_id,month);
    }
    
}
