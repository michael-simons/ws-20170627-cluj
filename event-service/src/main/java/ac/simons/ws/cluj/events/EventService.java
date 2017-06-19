package ac.simons.ws.cluj.events;

import java.util.GregorianCalendar;
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

    public EventEntity create(NewEventCmd newEvent) {
        final EventEntity entity = new EventEntity(GregorianCalendar.from(newEvent.getHeldOn()), newEvent.getName());
        if(newEvent.getStatus() != null) {
            entity.setStatus(newEvent.getStatus());
        }
        return this.eventRepository.save(entity);
    }
}
