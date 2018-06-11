package ua.kiev.prog.controller;

import org.springframework.web.bind.annotation.RequestParam;
import ua.kiev.prog.dao.ResponseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kiev.prog.model.AnswerAndCount;
import ua.kiev.prog.model.Response;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 06.06.2018.
 */
@Controller
public class PollController {
    @Autowired
    private ResponseDAO responseDAO;

    //Return home page at the beginning
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        System.out.println("Will return home page");
        String loginName = null;
        if (session.getAttribute("login_name") != null) {
            loginName = session.getAttribute("login_name").toString();
        }
        if (session.getAttribute("loginFailed") == null || (boolean)session.getAttribute("loginFailed") == false) {
            model.addAttribute("loginFailed", false);
        } else if ((boolean)session.getAttribute("loginFailed") == true) {
            model.addAttribute("loginFailed", true);
        }
        if (loginName == null) {
            model.addAttribute("loggedIn", false);
        } else {
            model.addAttribute("loggedIn", true);
            model.addAttribute("loginName", loginName);
        }
        return "home";
    }


    @RequestMapping(value = "/poll", method = RequestMethod.GET)
    public String poll(Model model) {
        return "poll";
    }

    @RequestMapping(value = "/poll", method = RequestMethod.POST)
    public String takePoll(Model model, @RequestParam String q1, @RequestParam String q2, HttpSession session) {
        if (session.getAttribute("login_name") != null) {
            responseDAO.addResponse(new Response(q1, q2, session.getAttribute("login_name").toString()));
        } else {
            responseDAO.addResponse(new Response(q1, q2, null));
        }
        if (session.getAttribute("login_name") == null) {
            session.setAttribute("took_poll", true);
            session.setAttribute("q1", q1);
            session.setAttribute("q2", q2);
        }
        return "redirect:/results";
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String sendResults(Model model, HttpSession session) {
        if (session.getAttribute("login_name") != null) {
            model.addAttribute("loggedIn", true);
            System.out.println("logged in: true");
            List<AnswerAndCount> answersQ1 = responseDAO.getQuestion1Responses();
            List<AnswerAndCount> answersQ2 = responseDAO.getQuestion2Responses();
            model.addAttribute("answersQ1", answersQ1);
            model.addAttribute("answersQ2", answersQ2);

            Response loggedInUserResponse = responseDAO.getByUserName(session.getAttribute("login_name").toString());
            model.addAttribute("answer1", loggedInUserResponse.getAnswer1());
            model.addAttribute("answer2", loggedInUserResponse.getAnswer2());

        } else {
            model.addAttribute("loggedIn", false);
            System.out.println("logged in: false");
            model.addAttribute("answer1", session.getAttribute("q1"));
            model.addAttribute("answer2", session.getAttribute("q2"));
        }
        return "results";
    }


}
