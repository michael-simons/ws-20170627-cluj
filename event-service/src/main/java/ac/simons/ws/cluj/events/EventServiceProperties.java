package ac.simons.ws.cluj.events;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
