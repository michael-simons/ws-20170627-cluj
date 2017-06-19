package ac.simons.ws.cluj.calendar;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EventService {

    private final RestTemplate restTemplate;

    public EventService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "emptyEvents")
    public List<Event> allEvents() {
        
        final ResponseEntity<List<Event>> response =  this.restTemplate
                .exchange("http://event-service/api/events", HttpMethod.GET, null, new ParameterizedTypeReference<List<Event>>() {
                });
        if(response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Could not retrieve events");
        }
        return response.getBody();
    }
    
    List<Event> emptyEvents() {
        return new ArrayList<>();
    }
}
