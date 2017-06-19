package ac.simons.ws.cluj.events;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
        this.mvc
                .perform(MockMvcRequestBuilders.get("/api/events"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", equalTo("test1")));
    }
}
