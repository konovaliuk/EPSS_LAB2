package commands;

import manager.Config;
import services.DisciplineService;
import services.UserDisciplineService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CommandAddDisciplineForUser implements ICommand{
    static final String USERID = "userId";
    static final String DISCIPLINEID = "disciplineId";


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
            return Config.getInstance().getProperty(Config.ADDMARK);
        }


        int userId = Integer.parseInt((request.getParameter(USERID)));
        int disciplineId = Integer.parseInt(request.getParameter(DISCIPLINEID));

        page = Config.getInstance().getProperty(Config.ADDUSER);

        UserDisciplineService userDisciplineService = new UserDisciplineService();

        if (userId == 0 || disciplineId == 0 ) {
            request.setAttribute("message", "User id and discipline id cannot be 0");
            return page;
        }


        if (!userDisciplineService.addUserDiscipline(userId, disciplineId)) {
            request.setAttribute("message", "This user already has such discipline ");
            return page;
        }

        page = Config.getInstance().getProperty(Config.ADDDISCIPLINEFORUSER);

        System.out.println("NextPage: "+page);
        System.out.println("");

        return page;
    }
}