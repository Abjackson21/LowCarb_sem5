package my.utm.ip.lowcarbon.models.electric.electricRepo;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.lowcarbon.models.electric.Electric;

@Repository
public interface ElectricRepository {
    List<Electric> getAllElectric();
    List<Electric> getAllElectricByUserId(String user_id);
    List<Electric> getAllElectricByMonth(int month);
    void addElectricUsage(final Electric electric);
    void updateElectricUsage(final Electric electric);
    Electric getElectricByMonth(String user_id, int month);
    void deleteElectricUsage(String user_id, int month);
    void deleteElectricByUserId(String user_id);
} 
