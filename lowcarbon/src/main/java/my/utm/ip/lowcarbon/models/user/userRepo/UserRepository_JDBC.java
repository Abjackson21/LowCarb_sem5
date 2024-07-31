package my.utm.ip.lowcarbon.models.user.userRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import my.utm.ip.lowcarbon.models.user.User;

public class UserRepository_JDBC implements UserRepository{

    @Autowired
    private JdbcTemplate template;
    
    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM users";
        System.out.println("SQL Query: " + sql);
        List<User> result = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return result;
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email=?";
        User user = template.queryForObject(sql, new Object[]{email},  new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO users (user_id, email, password, fullName, phoneNumber, address, category, role) VALUES (?,?,?,?,?,?,?,?)";
        user.setUser_id(generateCustomId());
        Object[] arg = {
            user.getUser_id(),
            user.getEmail(),
            user.getPassword(),
            user.getFullName(),
            user.getPhoneNumber(),
            user.getAddress(), 
            user.getCategory(),
            user.getRole()};

        template.update(sql, arg);
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET email=?, password=?, fullName=?, phoneNumber=?, address=?, category=?, role=? WHERE user_id=?";
        template.update(sql, 
            user.getEmail(),
            user.getPassword(),
            user.getFullName(),
            user.getPhoneNumber(),
            user.getAddress(), 
            user.getCategory(),
            user.getRole(),
            user.getUser_id());
    }
    

    @Override
    public String generateCustomId() {
        String sql = "SELECT MAX(CAST(SUBSTRING(user_id, 2) AS SIGNED)) FROM users";
        Integer maxExistingId = template.queryForObject(sql, Integer.class);

        maxExistingId = (maxExistingId != null) ? maxExistingId : 0;

        String customId = "P" + String.format("%03d", maxExistingId + 1);

        return customId;
    }

    @Override
    public void deleteParticipant(String participantId) {
        String sql = "DELETE FROM users WHERE user_id=?";
        template.update(sql, participantId);
    }
    
}
