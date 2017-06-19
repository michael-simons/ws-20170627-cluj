package ac.simons.ws.cluj.events;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventApi {
    @GetMapping("/api/events")
    public List<EventEntity> getEvents() {
        return new ArrayList<>();
    }
}
