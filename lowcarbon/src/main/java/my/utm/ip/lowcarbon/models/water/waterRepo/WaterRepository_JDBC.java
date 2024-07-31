package my.utm.ip.lowcarbon.models.water.waterRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import my.utm.ip.lowcarbon.models.water.WaterDAO;

public class WaterRepository_JDBC implements WaterRepository{

    @Autowired

    private JdbcTemplate template;

    @Override
    public List<WaterDAO> getAllWater() {
        try {
            String sql = "SELECT * FROM water";
            System.out.println("SQL Query: " + sql);
            List<WaterDAO> result = template.query(sql, new BeanPropertyRowMapper<>(WaterDAO.class));
        return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching water data from database", e);
        }
    }

    @Override
    public List<WaterDAO> getAllWaterByUserId(String user_id) {
        String sql = "SELECT * FROM water WHERE user_id=?";
        List<WaterDAO> water= template.query(sql, 
                    new BeanPropertyRowMapper<WaterDAO>(WaterDAO.class), user_id);

        return water;
    }

    @Override
    public List<WaterDAO> getAllWaterByMonth(int month) {
        String sql = "SELECT * FROM water WHERE water_month=?";
        List<WaterDAO> water= template.query(sql, 
                    new BeanPropertyRowMapper<WaterDAO>(WaterDAO.class), month);

        return water;
    }

    @Override
    public WaterDAO addWaterUsage(WaterDAO water) {
        String insertSql = "INSERT INTO water(water_month, water_numday, water_profacta, water_usagem3, water_usagem3RM, user_id) VALUES (?,?,?,?,?,?)";
        Object[] arg = {
            water.getWater_month(),
            water.getWater_numday(),
            water.getWater_profacta(),
            water.getWater_usagem3(),
            water.getWater_usagem3RM(),
            water.getUserId()};

        template.update(insertSql, arg);
        return water;
    }

    @Override
    public WaterDAO updateWaterUsage(WaterDAO water) {
        String sql = "UPDATE water SET water_numday=?, water_profacta=?, water_usagem3=?, water_usagem3RM=? WHERE water_month=? AND user_id=?";
        template.update(sql, 
            water.getWater_numday(), 
            water.getWater_profacta(), 
            water.getWater_usagem3(), 
            water.getWater_usagem3RM(), 
            water.getWater_month(), 
            water.getUserId());
        return water;
    }

    @Override
    public WaterDAO getWaterByMonth(String user_id, int month) {
        String sql = "SELECT * FROM water WHERE water_month=? AND user_id=?";
        WaterDAO water= template.queryForObject(sql, 
                    new BeanPropertyRowMapper<WaterDAO>(WaterDAO.class), month, user_id);

        return water;
    }

    @Override
    public void deleteWaterUsage(String user_id, int month) {
        String sql = "DELETE FROM water WHERE water_month=? AND user_id=?";
        template.update(sql, month, user_id);
    }

    @Override
    public void deleteWaterByUserId(String user_id) {
        String sql = "DELETE FROM water WHERE user_id=?";
        template.update(sql,user_id);
    }
}
