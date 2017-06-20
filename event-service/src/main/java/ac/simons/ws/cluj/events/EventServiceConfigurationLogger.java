package ac.simons.ws.cluj.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
