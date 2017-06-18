package ac.simons.ws.cluj.calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Michael J. Simons
 */
@Controller
public class IndexController {
    
    @GetMapping({"/", "index"})
    public String index() {
        return "index";
    }
}
