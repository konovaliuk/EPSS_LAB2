package commands;

import manager.Config;
import services.DisciplineService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CommandAddDiscipline implements ICommand{
    static final String TITLE = "title";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String page = null;
        HttpSession session = request.getSession();

        if (session.getAttribute("registerStatus") == null) {
            session.setAttribute("registerStatus", "do");
            return Config.getInstance().getProperty(Config.REGISTERUSER);
        }

        if (session.getAttribute("registerStatus").equals("GoTo")) {
            session.setAttribute("registerStatus", "do");
            return Config.getInstance().getProperty(Config.REGISTERUSER);
        }


        String title = request.getParameter(TITLE);

        page = Config.getInstance().getProperty(Config.REGISTERUSER);

        DisciplineService disciplineService = new DisciplineService();

        if (title == null || title.equals("") ) {
            request.setAttribute("message", "Title cannot be empty!");
            return page;
        }


        if (!disciplineService.addDiscipline(title)) {
            request.setAttribute("message", "This title is already occupied ");
            return page;
        }

        page = Config.getInstance().getProperty(Config.MAIN);

        System.out.println("NextPage: "+page);
        System.out.println("");

        return page;
    }
}