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

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Michael J. Simons
 */
@ConfigurationProperties(prefix = "event-service")
@Component
public class EventServiceProperties {
    /**
     * The default number of seats avaiable for each event.
     */
    private Integer defaultNumberOfSeats;
    
    /**
     * Some arbitrary information.
     */
    private String arbitraryInformation;

    public Integer getDefaultNumberOfSeats() {
        return defaultNumberOfSeats;
    }

    public void setDefaultNumberOfSeats(Integer defaultNumberOfSeats) {
        this.defaultNumberOfSeats = defaultNumberOfSeats;
    }

    public String getArbitraryInformation() {
        return arbitraryInformation;
    }

    public void setArbitraryInformation(String arbitraryInformation) {
        this.arbitraryInformation = arbitraryInformation;
    }
}
