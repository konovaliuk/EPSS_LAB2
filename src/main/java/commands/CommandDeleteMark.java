package commands;

import services.MarksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CommandDeleteMark implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        System.out.println("Deleting Mark: "+request.getParameter("markId"));
        String page = null;

        MarksService marksService = new MarksService();
        marksService.deleteMark(Long.valueOf(request.getParameter("markId")));

        ICommand nextCommand = new CommandGetUserMarksForDiscipline();

        return nextCommand.execute(request, response);
    }
}