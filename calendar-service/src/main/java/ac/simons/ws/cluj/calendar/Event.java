package ac.simons.ws.cluj.calendar;

import java.util.Calendar;

public class Event {

    private Calendar heldOn;

    private String name;

    public Calendar getHeldOn() {
        return heldOn;
    }

    public void setHeldOn(Calendar heldOn) {
        this.heldOn = heldOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}