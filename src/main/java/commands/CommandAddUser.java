package commands;

import manager.Config;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CommandAddUser implements ICommand{
    static final String EMAIL = "email";
    static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String page = null;
        HttpSession session = request.getSession();

        if (session.getAttribute("registerStatus") == null) {
            session.setAttribute("registerStatus", "do");
            return Config.getInstance().getProperty(Config.ADDUSER);
        }

        if (session.getAttribute("registerStatus").equals("GoTo")) {
            session.setAttribute("registerStatus", "do");
            return Config.getInstance().getProperty(Config.ADDUSER);
        }


        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        String role = request.getParameter(ROLE);
        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);


        page = Config.getInstance().getProperty(Config.ADDUSER);

        UserService userService = new UserService();

        if (email == null || email.equals("") || password == null || password.equals("")) {
            request.setAttribute("message", "Username and password cannot be empty!");
            return page;
        }


        if (!userService.addUser(email, password, role, name, surname)) {
            request.setAttribute("message", "This email is already occupied :(");
            return page;
        }

        page = Config.getInstance().getProperty(Config.MAIN);
        session.setAttribute("email", email);
        session.setAttribute("userId", userService.getUserIdByUsername(email));

        System.out.println("NextPage: "+page);
        System.out.println("");

        return page;
    }
}