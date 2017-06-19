package ac.simons.ws.cluj.calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Michael J. Simons
 */
@Controller
public class IndexController {
    
    private final EventService eventService;

    public IndexController(EventService eventService) {
        this.eventService = eventService;
    }
    
    @GetMapping({"/", "index"})
    public String index(final Model model) {
        model.addAttribute("events", this.eventService.allEvents());
        return "index";
    }
}
