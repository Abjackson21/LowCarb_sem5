package my.utm.ip.lowcarbon.models.water.waterRepo;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.lowcarbon.models.water.WaterDAO;

@Repository
public interface WaterRepository {
    List<WaterDAO> getAllWater();
    List<WaterDAO> getAllWaterByUserId(String user_id);
    List<WaterDAO> getAllWaterByMonth(int month);
    WaterDAO addWaterUsage(final WaterDAO water);
    WaterDAO updateWaterUsage(final WaterDAO water);
    WaterDAO getWaterByMonth(String user_id, int month);
    void deleteWaterUsage(String user_id, int month);
    void deleteWaterByUserId(String user_id);
}
