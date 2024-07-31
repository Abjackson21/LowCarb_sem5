package my.utm.ip.lowcarbon.controllers;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.PostMapping;

import my.utm.ip.lowcarbon.models.event.Event;
import my.utm.ip.lowcarbon.models.event.eventRepo.EventRepository;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepo;

    @RequestMapping("/event")
    public String home(Model model) {
        List<Event> allEvents = eventRepo.getAllEvent();
         Gson gson = new Gson();
         String eventsJson = gson.toJson(allEvents);
         model.addAttribute("events", eventsJson);

         return "event/event";
    }

    @PostMapping("/addEvent")
    public String addEvent(@RequestParam("event_name") String eventName,
            @RequestParam("event_desc") String eventDesc,
            @RequestParam("event_date") String eventDate,
            @RequestParam("time_from") String timeFrom,
            @RequestParam("time_to") String timeTo,
            Model model) throws ParseException {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = dateFormat.parse(eventDate);
        Date sqlEventDate = new java.sql.Date(parsedDate.getTime());


        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        java.util.Date parsedTimeFrom = timeFormat.parse(timeFrom);
        java.util.Date parsedTimeTo = timeFormat.parse(timeTo);
        Time sqlTimeFrom = new java.sql.Time(parsedTimeFrom.getTime());
        Time sqlTimeTo = new java.sql.Time(parsedTimeTo.getTime());

        Event event = new Event();
        event.setEvent_name(eventName);
            event.setEvent_desc(eventDesc);
            event.setEvent_date(sqlEventDate);
            event.setTime_from(sqlTimeFrom);
            event.setTime_to(sqlTimeTo);

        eventRepo.addEvent(event);
        return "redirect:/event";
    }
}
