/*
 * Copyright 2017 michael-simons.eu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

/**
 * @author Michael J. Simons
 */
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
