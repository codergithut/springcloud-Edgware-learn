package tianjian.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import tianjian.exception.web.view.ViewHandlerException;

@Controller
public class ViewController {

    @GetMapping("view")
    public String viewTest() throws ViewHandlerException {
        throw new ViewHandlerException("view can not find error");
    }

    @GetMapping("view1")
    public String view1Test() throws Exception {
        throw new Exception("you fail as i want");
    }
}
