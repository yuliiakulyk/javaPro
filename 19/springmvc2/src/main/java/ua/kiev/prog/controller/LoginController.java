package ua.kiev.prog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Yuliia Kulyk on 06.06.2018.
 */
@Controller
public class LoginController {
    private final String LOGIN_NAME = "admin";
    private final String LOGIN_PASS = "admin";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String sendLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String doLogin(@RequestParam String login, @RequestParam String password, HttpSession session) {
        if (LOGIN_NAME.equals(login) && LOGIN_PASS.equals(password)) {
            session.setAttribute("login_name", login);
            session.setAttribute("loginFailed", false);
        } else {
            session.setAttribute("loginFailed", true);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private String doLogout(HttpSession session) {
        session.setAttribute("login_name", null);
        session.setAttribute("loginFailed", false);
        return "redirect:/";
    }
}
