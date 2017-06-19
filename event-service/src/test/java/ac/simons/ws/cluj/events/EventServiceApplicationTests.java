package ac.simons.ws.cluj.events;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EventServiceApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getEventsShouldWork() {
        final List<EventEntity> events = this.restTemplate.exchange(
                "/api/events", 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<EventEntity>>() {}
        ).getBody();
        assertThat(
                events.get(0).getName(), 
                is(equalTo("Get the most out of your data layer"))
        );
    }
}
