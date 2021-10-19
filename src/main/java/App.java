import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import util.validation.EmailValidator;
import util.validation.Validator;

import javax.servlet.http.HttpServletRequest;

@Controller
public class App {
    private static ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(path = "/app/user", produces = "application/json")
    public ResponseEntity getUser() throws JsonProcessingException {
        User user = User.prepare()
                .withUsername("admin")
                .withPassword("admin")
                .withEmail("contact@email.com")
                .withBirthday(1970, 1, 1)
                .withName("Admin")
                .register();
        return ResponseEntity.accepted()
                .body(objectMapper.writeValueAsString(user));
    }

    @GetMapping(path = "app/validate", produces = "application/json")
    public ResponseEntity<String> checkValidation(HttpServletRequest request) throws JsonProcessingException {
        String email = request.getParameter("email");
        Validator<String> emailValidator = new EmailValidator();
        boolean isValid = emailValidator.check(email);
        return ResponseEntity.ok().body(objectMapper.writeValueAsString(isValid));
    }

    @GetMapping(path = "/app/model", produces = "application/json")
    public ResponseEntity<Object> showModel(Model model) {
        return ResponseEntity.ok().body(model.getAttribute("user"));
    }

    @ModelAttribute
    public void addUser(Model model) {
        User user = User.prepare()
                .withUsername("admin")
                .withPassword("admin")
                .withEmail("contact@email.com")
                .withBirthday(1970, 1, 1)
                .withName("Admin")
                .register();
        model.addAttribute("user", user);
    }
}