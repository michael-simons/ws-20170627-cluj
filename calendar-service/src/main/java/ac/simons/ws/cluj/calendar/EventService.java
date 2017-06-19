package ac.simons.ws.cluj.calendar;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EventService {
    private final RestTemplate restTemplate;

    public EventService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
     public List<Event> allEvents() {
        return this.restTemplate
                .exchange("http://event-service/api/events", HttpMethod.GET, null, new ParameterizedTypeReference<List<Event>>() {})
                .getBody();
    }
}
