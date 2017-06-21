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
package ac.simons.ws.cluj.events;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author Michael J. Simons
 */
@RestController
@RequestMapping("/api/events")
public class EventApi {
    private final EventService eventService;

    public EventApi(EventService eventService) {
        this.eventService = eventService;
    }
    
    @GetMapping
    public List<EventEntity> getEvents() {
        return this.eventService.allEvents();
    }
    
    @PostMapping
    @ResponseStatus(CREATED)
    public EventEntity createEvent(final @Valid @RequestBody NewEventCmd newEvent) {
        return this.eventService.create(newEvent);
    }
}
