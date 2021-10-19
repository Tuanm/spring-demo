package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import util.JSPNames;

@Controller
class UserProfileServlet {
    @GetMapping(path = "/profile")
    public ModelAndView handleGet() {
        return new ModelAndView(JSPNames.PROFILE);
    }
}