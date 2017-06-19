package ac.simons.ws.cluj.events;

import ac.simons.ws.cluj.events.EventEntity.Status;
import java.time.ZonedDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class NewEventCmd {

    @NotNull
    private ZonedDateTime heldOn;

    @NotBlank
    @Size(max = 512)
    private String name;

    private Status status;

    public ZonedDateTime getHeldOn() {
        return heldOn;
    }

    public void setHeldOn(ZonedDateTime heldOn) {
        this.heldOn = heldOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
