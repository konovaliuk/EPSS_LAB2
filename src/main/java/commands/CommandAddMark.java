package commands;

import manager.Config;
import services.MarksService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CommandAddMark implements ICommand {
    private static final String AMOUNT = "amount";
    private static final String TYPE = "type";
    private static final String DESCRIPTION = "description";
    private static final String STUDENTID = "studentId";
    private static final String TEACHERID = "teacherId";
    private static final String DISCIPLINEID = "disciplineID";


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


        int amount = Integer.parseInt(request.getParameter(AMOUNT));
        String type = request.getParameter(TYPE);
        String description = request.getParameter(DESCRIPTION);
        int studentId = Integer.parseInt(request.getParameter(STUDENTID));
        int teacherId = Integer.parseInt(request.getParameter(TEACHERID));
        int disciplineId = Integer.parseInt(request.getParameter(DISCIPLINEID));


        page = Config.getInstance().getProperty(Config.ADDMARK);

        MarksService marksService = new MarksService();

        if (type == null || type.equals("") || studentId == 0 || teacherId == 0 || disciplineId == 0) {
            request.setAttribute("message", "Mark cannot be added (please, enter type, student id, teacher id and discipline id)");
            return page;
        }


        marksService.addMark(amount, type, description, studentId, teacherId, disciplineId) ;

        page = Config.getInstance().getProperty(Config.MAIN);

        System.out.println("NextPage: " + page);
        System.out.println("");

        return page;
    }
}