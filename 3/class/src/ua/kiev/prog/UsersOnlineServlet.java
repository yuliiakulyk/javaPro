package ua.kiev.prog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Yuliia Kulyk on 05.05.2018.
 */
public class UsersOnlineServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try (PrintWriter writer = new PrintWriter(resp.getOutputStream())) {
            writer.print(UsersOnline.getUsersOnlineNames());
            System.out.println("Users online: " + UsersOnline.getUsersOnlineNames());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        StringBuilder builder = new StringBuilder();
        String s;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()))) {
            while ((s = reader.readLine()) != null) {
                  builder.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        UsersOnline.addUserOnline(builder.toString());
        req.getSession(true).setAttribute("userName", builder.toString());
        System.out.println("set attribute 'userName' for session for user " + builder.toString());
        try (PrintWriter writer = new PrintWriter(resp.getOutputStream())) {
            System.out.println("sending response about adding user online");
            writer.println("Added user online '" + builder.toString() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Added user online '" + builder.toString() + "'");
    }
}
