package my.utm.ip.lowcarbon.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import my.utm.ip.lowcarbon.models.electric.electricRepo.ElectricRepository_JDBC;
import my.utm.ip.lowcarbon.models.event.eventRepo.EventRepository;
import my.utm.ip.lowcarbon.models.event.eventRepo.EventRepository_JDBC;
import my.utm.ip.lowcarbon.models.recycle.recycleRepo.RecycleRepository_JDBC;
import my.utm.ip.lowcarbon.models.user.userRepo.UserRepository;
import my.utm.ip.lowcarbon.models.user.userRepo.UserRepository_JDBC;
import my.utm.ip.lowcarbon.models.water.waterRepo.WaterRepository;
import my.utm.ip.lowcarbon.models.water.waterRepo.WaterRepository_JDBC;
import my.utm.ip.lowcarbon.services.monthlyUpdate.waterService.WaterService;
import my.utm.ip.lowcarbon.services.monthlyUpdate.waterService.WaterService_DB;

@Configuration
public class AppConfig {

    @Bean
    UserRepository userRepository(){
        return new UserRepository_JDBC();
    }

    @Bean
    public EventRepository eventRepository(){
        return new EventRepository_JDBC();
    }
    
    @Bean
    public WaterService waterService() {
        return new WaterService_DB();
    }

    @Bean
    WaterRepository waterRepository(){
        return new WaterRepository_JDBC();
    }

    @Bean
    ElectricRepository_JDBC electriRepository(){
        return new ElectricRepository_JDBC();
    }

    @Bean
    RecycleRepository_JDBC recycleRepository(){
        return new RecycleRepository_JDBC();
    }
}
