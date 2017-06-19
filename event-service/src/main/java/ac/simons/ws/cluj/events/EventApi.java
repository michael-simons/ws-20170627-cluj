package ac.simons.ws.cluj.events;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventApi {
    private final EventService eventService;

    public EventApi(EventService eventService) {
        this.eventService = eventService;
    }
    
    @GetMapping
    public List<EventEntity> getEvents() {
        return this.eventService.allEvents();
    }
}
