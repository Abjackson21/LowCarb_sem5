package my.utm.ip.lowcarbon.models.event.eventRepo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import my.utm.ip.lowcarbon.models.event.Event;



public class EventRepository_JDBC implements EventRepository{

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Event> getAllEvent() {
        String sql = "SELECT * FROM event";
        List<Event> event = template.query(sql, new BeanPropertyRowMapper<Event>(Event.class));
        return event;
    }

    @Override
    public List<Event> getEventsByDate(Date eventDate) {
        String sql = "SELECT * FROM event WHERE event_date=?";
        List<Event> event = template.query(sql, new Object[]{eventDate},new BeanPropertyRowMapper<>(Event.class));
        return event;
    }

    @Override
    public void addEvent(Event event){
        String sql = "INSERT INTO event (event_id, event_name, event_desc, event_date, time_from, time_to) VALUES (DEFAULT,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, event.getEvent_name());
            ps.setString(2, event.getEvent_desc());
            ps.setDate(3, event.getEvent_date());
            ps.setTime(4, event.getTime_from());
            ps.setTime(5, event.getTime_to());

            return ps;
        }, keyHolder);
        //Long generatedId = keyHolder.getKey().longValue();
    }

    
    
}
