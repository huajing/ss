package c.c.k.ctn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("aaa")
    public String home(Model model){
        model.addAttribute("a", "bc");
        return "abc";
    }
}
