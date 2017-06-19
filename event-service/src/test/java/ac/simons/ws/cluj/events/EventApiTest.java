package ac.simons.ws.cluj.events;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EventApiTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EventService eventService;

    @Test
    public void getEventsShouldWork() throws Exception {
        final ZonedDateTime now = ZonedDateTime.now();
        List<EventEntity> expectedEvents
                = Arrays.asList(
                        new EventEntity(GregorianCalendar.from(now.plusDays(3)), "test1"),
                        new EventEntity(GregorianCalendar.from(now.plusWeeks(1)), "test2")
                );
        when(eventService.allEvents()).thenReturn(expectedEvents);

        this.mvc
                .perform(get("/api/events"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is(equalTo("test1"))));
        
        verify(this.eventService).allEvents();
        verifyNoMoreInteractions(this.eventService);
    }
}
