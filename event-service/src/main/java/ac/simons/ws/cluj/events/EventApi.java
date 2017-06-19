package ac.simons.ws.cluj.events;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

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
    
    @PostMapping
    @ResponseStatus(CREATED)
    public EventEntity createEvent(final @Valid @RequestBody NewEventCmd newEvent) {
        return this.eventService.create(newEvent);
    }
}
