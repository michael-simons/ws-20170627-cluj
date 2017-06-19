package ac.simons.ws.cluj.events;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface EventRepository extends Repository<EventEntity, Integer> {
    List<EventEntity> findAllByOrderByHeldOnAsc();
}
