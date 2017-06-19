package ac.simons.ws.cluj.events;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EventServiceTest {
    
    @Autowired
    private EventRepository eventRepository;
    
    @Test
    public void allEventsShouldWork() {
        final EventService eventService = new EventService(eventRepository);
        assertThat(eventService.allEvents().size(), is(3));
    }
}