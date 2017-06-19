package ac.simons.ws.cluj.events;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static java.time.OffsetTime.now;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EventApiTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EventService eventService;

    @Test
    public void getEventsShouldWork() throws Exception {
        ZonedDateTime now = ZonedDateTime.now();
        List<EventEntity> expectedEvents
                = Arrays.asList(
                        new EventEntity(GregorianCalendar.from(now.plusDays(3)), "test1"),
                        new EventEntity(GregorianCalendar.from(now.plusWeeks(1)), "test2")
                );
        Mockito.when(eventService.allEvents()).thenReturn(expectedEvents);

        this.mvc
                .perform(MockMvcRequestBuilders.get("/api/events"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", equalTo("test1")));
    }
}
