package my.utm.ip.lowcarbon.models.recycle.recycleRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import my.utm.ip.lowcarbon.models.recycle.Recycle;

public class RecycleRepository_JDBC implements RecycleRepository{

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Recycle> getAllRecycle() {
        try {
            String sql = "SELECT * FROM recycle";
            System.out.println("SQL Query: " + sql);
            List<Recycle> result = template.query(sql, new BeanPropertyRowMapper<>(Recycle.class));
        return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching water data from database", e);
        }
    }

    @Override
    public List<Recycle> getAllRecycleByUserId(String user_id) {
        String sql = "SELECT * FROM recycle WHERE user_id=?";
            List<Recycle> result = template.query(sql, new BeanPropertyRowMapper<>(Recycle.class),user_id);
            return result;
    }

    @Override
    public List<Recycle> getAllRecycleByMonth(int month) {
        String sql = "SELECT * FROM recycle WHERE recycle_month=?";
        List<Recycle> result = template.query(sql, new BeanPropertyRowMapper<>(Recycle.class),month);
        return result;
    }

    @Override
    public void addRecycleActivity(Recycle recycle) {
        String insertSql = "INSERT INTO recycle (recycle_month, collectedKG, collectedRM, user_id) VALUES (?,?,?,?)";
        Object[] arg = {
            recycle.getRecycle_month(),
            recycle.getCollectedKG(),
            recycle.getCollectedRM(),
            recycle.getUser_id()};

        template.update(insertSql, arg);
    }

    @Override
    public void updateRecycleActivity(Recycle recycle) {
        String sql = "UPDATE recycle SET collectedKG=?, collectedRM=? WHERE recycle_month=? AND user_id=?";
        template.update(sql, 
            recycle.getCollectedKG(),
            recycle.getCollectedRM(),
            recycle.getRecycle_month(),
            recycle.getUser_id());
    }

    @Override
    public Recycle getRecycleByMonth(String user_id, int month) {
        String sql = "SELECT * FROM recycle WHERE recycle_month=? AND user_id=?";
        Recycle recycle= template.queryForObject(sql, 
                    new BeanPropertyRowMapper<Recycle>(Recycle.class), month, user_id);

        return recycle;
    }

    @Override
    public void deleteRecycleActivity(String user_id, int month) {
        String sql = "DELETE FROM recycle WHERE recycle_month=? AND user_id=?";
        template.update(sql, month, user_id);
    }

    @Override
    public void deleteRecycleByUserId(String user_id) {
        String sql = "DELETE FROM recycle WHERE user_id=?";
        template.update(sql,user_id);
    }
    
}
