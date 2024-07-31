package my.utm.ip.lowcarbon.services.monthlyUpdate.waterService;

import java.util.*;

import org.springframework.stereotype.Service;

import my.utm.ip.lowcarbon.models.water.Water;

@Service
public interface WaterService {
    List<Water> getAllWater();
    List<Water> getAllWaterByUserId(String user_id);
    Water addWaterUsage(final Water water);
    Water updateWaterUsage(final Water water);
    Water getWaterByMonth(String user_id, int month);
    void deleteWaterUsage(String user_id, int month);
}
