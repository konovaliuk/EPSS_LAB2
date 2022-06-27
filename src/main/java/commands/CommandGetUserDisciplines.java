package commands;

import manager.Config;
import services.UserService;
import services.DisciplineService;
import services.UserDisciplineService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CommandGetUserDisciplines implements ICommand {
    private static final String USER_ID = "userId";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String page = null;
        HttpSession session = request.getSession();
        session.setAttribute("getUserDisciplines", "GoTo");
        Long userId = (Long) session.getAttribute(USER_ID);
        page = Config.getInstance().getProperty(Config.USERDISCIPLINES);

        if (userId!=null) {
            UserDisciplineService userDisciplineService = new UserDisciplineService();
            request.setAttribute("userDisciplines", UserDisciplineService.findAllUserDisciplines(userId));
        }

        return page;
    }
}