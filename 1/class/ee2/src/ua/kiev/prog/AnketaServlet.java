package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Yuliia Kulyk on 16.04.2018.
 */
public class AnketaServlet extends HttpServlet {
    int question1answer1 = 0;
    int question1answer2 = 0;
    int question2answer1 = 0;
    int question2answer2 = 0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer1 = req.getParameter("q1");
        String answer2 = req.getParameter("q2");
        if (answer1.equals("answer11")) {
            question1answer1++;
        } else if (answer1.equals("answer12")) {
            question1answer2++;
        }

        if (answer2.equals("answer21")) {
            question2answer1++;
        } else if (answer2.equals("answer22")) {
            question2answer2++;
        }

        HttpSession session = req.getSession(false);
        session.setAttribute("answeredPoll", "true");
        session.setAttribute("answer1", answer1);
        session.setAttribute("answer2", answer2);
        session.setAttribute("question1answer1", "" + question1answer1);
        session.setAttribute("question1answer2", "" + question1answer2);
        session.setAttribute("question2answer1", "" + question2answer1);
        session.setAttribute("question2answer2", "" + question2answer2);

        resp.sendRedirect("index.jsp");
        /*
        resp.getWriter().println("<html>" +
                "<head><title>Anketa Stat</title></head>" +
                "<body><h1>" +
                "<p>q1 answer1: " + question1answer1 + "</p>" +
                "<p>q1 answer2: " + question1answer2 + "</p>" +
                "<p>q2 answer1: " + question2answer1 + "</p>" +
                "<p>q2 answer2:     " + question2answer2 + "</p>" +
                "</h1></body></html>");
        */
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("<html><head><title>Anketa</title></head><body>");
        pw.println("<form action=\"/anketa\" method=\"POST\">");
        pw.println("<p>Question1</p>");
        pw.println("<input type=\"radio\" name=\"q1\" value=\"answer11\">");
        pw.println("<label for=\"answer11\">answer11</label><br>");
        pw.println("<input type=\"radio\" name=\"q1\"value=\"answer12\">");
        pw.println("<label for=\"answer12\">answer12</label><br>");
        pw.println("<p>Question2</p>");
        pw.println("<input type=\"radio\" name=\"q2\" value=\"answer21\">");
        pw.println("<label for=\"answer21\">answer21</label><br>");
        pw.println("<input type=\"radio\" name=\"q2\" value=\"answer22\">");
        pw.println("<label for=\"answer22\">answer22</label><br>");
        pw.println("<input type=\"submit\">");
        pw.println("</form></body></html>");
    }
}
