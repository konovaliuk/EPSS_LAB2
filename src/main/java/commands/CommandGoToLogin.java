package commands;

import manager.Config;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandGoToLogin implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;

        page = Config.getInstance().getProperty(Config.LOGIN);

        System.out.println("NextPage: "+page);
        return page;
    }

}