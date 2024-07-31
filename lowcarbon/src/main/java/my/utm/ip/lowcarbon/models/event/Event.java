package my.utm.ip.lowcarbon.models.event;

import java.sql.Date;
import java.sql.Time;

public class Event {
    private int event_id;
    private String event_name;
    private String event_desc;
    private Date event_date;
    private Time time_from;
    private Time time_to;
    
    public Event() {
    }

    public Event(int event_id, String event_name, String event_desc, Date event_date, Time time_from, Time time_to) {
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_desc = event_desc;
        this.event_date = event_date;
        this.time_from = time_from;
        this.time_to = time_to;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_desc() {
        return event_desc;
    }

    public void setEvent_desc(String event_desc) {
        this.event_desc = event_desc;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public Time getTime_from() {
        return time_from;
    }

    public void setTime_from(Time time_from) {
        this.time_from = time_from;
    }

    public Time getTime_to() {
        return time_to;
    }

    public void setTime_to(Time time_to) {
        this.time_to = time_to;
    }

    
}
