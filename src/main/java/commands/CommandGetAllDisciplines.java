package commands;

import manager.Config;
import services.DisciplineService;
import services.UserService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CommandGetAllDisciplines implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String page = null;

        page = Config.getInstance().getProperty(Config.ALLDISCIPLINES);

        DisciplineService disciplineService = new DisciplineService();
        request.setAttribute("disciplines", disciplineService.findAllDisciplines());


        return page;
    }


}