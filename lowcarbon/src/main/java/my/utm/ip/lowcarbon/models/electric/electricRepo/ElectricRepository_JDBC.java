package my.utm.ip.lowcarbon.models.electric.electricRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import my.utm.ip.lowcarbon.models.electric.Electric;

public class ElectricRepository_JDBC implements ElectricRepository{

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Electric> getAllElectric() {
        try {
            String sql = "SELECT * FROM electric";
            System.out.println("SQL Query: " + sql);
            List<Electric> result = template.query(sql, new BeanPropertyRowMapper<>(Electric.class));
        return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching water data from database", e);
        }
    }

    @Override
    public List<Electric> getAllElectricByUserId(String user_id) {
        String sql = "SELECT * FROM electric WHERE user_id=?";
            List<Electric> result = template.query(sql, new BeanPropertyRowMapper<>(Electric.class),user_id);
            return result;
    }

    @Override
    public List<Electric> getAllElectricByMonth(int month) {
        String sql = "SELECT * FROM electric WHERE electric_month=?";
        List<Electric> result = template.query(sql, new BeanPropertyRowMapper<>(Electric.class),month);
        return result;
    }

    @Override
    public void addElectricUsage(Electric electric) {
        String insertSql = "INSERT INTO electric(electric_month, electric_numday, electric_profacta, electric_usagekWh, electric_usagekWhRM, user_id) VALUES (?,?,?,?,?,?)";
        Object[] arg = {
            electric.getElectric_month(),
            electric.getElectric_numday(),
            electric.getElectric_profacta(),
            electric.getElectric_usagekWh(),
            electric.getElectric_usagekWhRM(),
            electric.getUser_id()};

        template.update(insertSql, arg);
    }

    @Override
    public void updateElectricUsage(Electric electric) {
        String sql = "UPDATE electric SET electric_numday=?, electric_profacta=?, electric_usagekWh=?, electric_usagekWhRM=? WHERE electric_month=? AND user_id=?";
        template.update(sql, 
        electric.getElectric_numday(),
        electric.getElectric_profacta(),
        electric.getElectric_usagekWh(),
        electric.getElectric_usagekWhRM(), 
        electric.getElectric_month(), 
        electric.getUser_id());
    }

    @Override
    public Electric getElectricByMonth(String user_id, int month) {
        String sql = "SELECT * FROM electric WHERE electric_month=? AND user_id=?";
        Electric electric= template.queryForObject(sql, 
                    new BeanPropertyRowMapper<Electric>(Electric.class), month, user_id);

        return electric;
    }

    @Override
    public void deleteElectricUsage(String user_id, int month) {
        String sql = "DELETE FROM electric WHERE electric_month=? AND user_id=?";
        template.update(sql, month, user_id);
    }

    @Override
    public void deleteElectricByUserId(String user_id) {
        String sql = "DELETE FROM electric WHERE user_id=?";
        template.update(sql, user_id);
    }
    
}
