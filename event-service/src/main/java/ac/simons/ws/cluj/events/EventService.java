package ac.simons.ws.cluj.events;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    public List<EventEntity> allEvents() {
        return new ArrayList<>();
    }
}