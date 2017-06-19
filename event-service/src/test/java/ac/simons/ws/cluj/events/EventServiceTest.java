package ac.simons.ws.cluj.events;

import ac.simons.ws.cluj.events.EventEntity.Status;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EventServiceTest {

    @Autowired
    private EventRepository eventRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void allEventsShouldWork() {
        final EventService eventService = new EventService(eventRepository);
        assertThat(eventService.allEvents().size(), is(3));
    }

    @Test
    public void createShouldWork() {
        final EventService eventService = new EventService(eventRepository);

        final ZonedDateTime now = ZonedDateTime.now();

        final NewEventCmd cmd = new NewEventCmd();
        cmd.setHeldOn(now);
        cmd.setName("test");
        cmd.setStatus(Status.open);
        final EventEntity newEntity = eventService.create(cmd);

        assertThat(newEntity.getId(), is(notNullValue()));
        assertThat(newEntity.getName(), is(equalTo("test")));
        assertThat(newEntity.getHeldOn(), is(equalTo(GregorianCalendar.from(now))));
    }

    @Test
    public void constraintShouldFire() {
        final EventService eventService = new EventService(eventRepository);

        final NewEventCmd cmd = new NewEventCmd();
        cmd.setHeldOn(ZonedDateTime.of(LocalDateTime.parse("2017-06-26T18:30:00"), ZoneId.systemDefault()));
        cmd.setName("Get the most out of your data layer");
        cmd.setStatus(Status.open);

        expectedException.expect(DataIntegrityViolationException.class);
        eventService.create(cmd);
    }
}