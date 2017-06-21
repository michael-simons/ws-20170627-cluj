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

import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Michael J. Simons
 */
@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventEntity> allEvents() {
        return this.eventRepository.findAllByOrderByHeldOnAsc();
    }

    public EventEntity create(NewEventCmd newEvent) {
        final EventEntity entity = new EventEntity(GregorianCalendar.from(newEvent.getHeldOn()), newEvent.getName());
        if(newEvent.getStatus() != null) {
            entity.setStatus(newEvent.getStatus());
        }
        return this.eventRepository.save(entity);
    }
}
