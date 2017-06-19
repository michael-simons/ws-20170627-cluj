package ac.simons.ws.cluj.events;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventEntity> allEvents() {
        return this.eventRepository.findAllByOrderByHeldOnAsc();
    }
}
