package ac.simons.ws.cluj.events;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {
    private final EntityManager entityManager;

    public EventService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional(readOnly = true)
    public List<EventEntity> allEvents() {
        return this.entityManager
                .createQuery(
                        "Select event from EventEntity event order by event.heldOn", 
                        EventEntity.class
                )
                .getResultList();
    }
}
