package commands;

import manager.Config;
import manager.Message;
import services.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static commands.CommandAddUser.EMAIL;
import static commands.CommandAddUser.PASSWORD;

public class CommandLogin implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String page = null;
        String username = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        HttpSession session = request.getSession();
        session.setAttribute("registerStatus", "GoTo");

        page = Config.getInstance().getProperty(Config.MAIN);

        UserService userService = new UserService();

        if (!userService.checkAuthorization(username, password)) {
            page = Config.getInstance().getProperty(Config.LOGIN);
            request.setAttribute("message", Message.getInstance().getProperty(Message.LOGIN_ERROR));
            return page;
        }


        session.setAttribute("username", username);
        request.setAttribute("username", username);
        session.setAttribute("userId", userService.getUserIdByUsername(username));

        System.out.println("NextPage: "+page);
        System.out.println("");

        return page;
    }
    }

