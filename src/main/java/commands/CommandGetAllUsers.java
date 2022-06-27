package commands;
import manager.Config;
import services.UserService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CommandGetAllUsers implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String page = null;

        page = Config.getInstance().getProperty(Config.ALLUSERS);

        UserService userService = new UserService();
        request.setAttribute("users", userService.findAllUsers());


        return page;
    }


}