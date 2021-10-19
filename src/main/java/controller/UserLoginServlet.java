package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserLogin;
import util.JSPNames;
import util.ResponseMessages;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserLoginServlet {
    @PostMapping(path = "/login")
    public ModelAndView handlePost(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = UserLogin.login(username, password);
        if (user == null) {
            return new ModelAndView(JSPNames.LOGIN)
                    .addObject("responseMessage",
                            ResponseMessages.USERNAME_OR_PASSWORD_INCORRECT);
        }
        request.setAttribute("name", user.name);
        request.setAttribute("email", user.email);
        request.setAttribute("birthday", user.birthday);
        return new ModelAndView(JSPNames.PROFILE);
    }

    @GetMapping(path = "/login")
    public ModelAndView handleGet() {
        return new ModelAndView(JSPNames.LOGIN);
    }
}