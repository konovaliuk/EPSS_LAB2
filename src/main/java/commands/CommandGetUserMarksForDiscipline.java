package commands;

import manager.Config;
import services.MarksService;
import services.UserService;
import services.DisciplineService;
import services.UserDisciplineService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CommandGetUserMarksForDiscipline implements ICommand {
    private static final String USER_ID = "userId";
    private static final String DISCIPLINE_ID = "disciplineId";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String page = null;
        HttpSession session = request.getSession();
        session.setAttribute("getUserMarksForDiscipline", "GoTo");
        Long userId = (Long) session.getAttribute(USER_ID);
        Long disciplineId = (Long) session.getAttribute(DISCIPLINE_ID);
        page = Config.getInstance().getProperty(Config.USERDISCIPLINES);

        if (userId!=null || userId!= 0 || disciplineId!= null || disciplineId!=0) {

            MarksService marksService = new MarksService();
            request.setAttribute("userMarks", MarksService.findAllUserMarksForDiscipline(userId, disciplineId));
        }

        return page;
    }
}