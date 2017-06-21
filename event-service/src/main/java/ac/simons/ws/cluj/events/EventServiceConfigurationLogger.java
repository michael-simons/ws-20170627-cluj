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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Michael J. Simons
 */
@Component
public class EventServiceConfigurationLogger implements CommandLineRunner {

    static final Logger LOG = LoggerFactory
		.getLogger(EventServiceConfigurationLogger.class);
    
    private final EventServiceProperties eventServiceProperties;

    public EventServiceConfigurationLogger(EventServiceProperties eventServiceProperties) {
        this.eventServiceProperties = eventServiceProperties;
    }
    
    @Override
    public void run(String... strings) throws Exception {
        LOG.debug("Default number of seats is {}", 
                eventServiceProperties.getDefaultNumberOfSeats());
        LOG.debug("More information {}", eventServiceProperties.getArbitraryInformation());
    }
}
