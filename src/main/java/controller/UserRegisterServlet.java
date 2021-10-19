package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserRegister;
import util.JSPNames;
import util.ResponseMessages;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class UserRegisterServlet {
    @PostMapping(path = "/register")
    public ModelAndView handlePost(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        User user = User.prepare()
                .withUsername(username)
                .withPassword(password)
                .withName(name)
                .withEmail(email)
                .withBirthday(birthday).register();
        boolean registered = UserRegister.tryRegister(user);
        if (!registered) {
            return new ModelAndView(JSPNames.REGISTER)
                    .addObject("responseMessage",
                            ResponseMessages.USERNAME_EXISTED);
        }
        return new ModelAndView(JSPNames.LOGIN);
    }

    @GetMapping(path = "/register")
    public ModelAndView handleGet() {
        return new ModelAndView(JSPNames.REGISTER);
    }
}