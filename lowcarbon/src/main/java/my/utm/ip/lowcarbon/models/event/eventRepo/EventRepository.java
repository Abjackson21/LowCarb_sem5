package my.utm.ip.lowcarbon.models.event.eventRepo;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import my.utm.ip.lowcarbon.models.event.Event;

@Repository
public interface EventRepository {
    List<Event> getAllEvent();
    List<Event> getEventsByDate(Date selectedDate);
    void addEvent(Event event);
}
