package controllers;

import commands.ICommand;
import manager.Message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Controller", value = "")
public class Controller extends HttpServlet {

    ControllerHelper controllerHelper = ControllerHelper.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;

        try {
            ICommand command = controllerHelper.getCommand(request);
            page = command.execute(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("messageError", Message.getInstance().getProperty(Message.SERVLET_EXCEPTION));

        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("messageError",Message.getInstance().getProperty(Message.IO_EXCEPTION));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (request.getParameter("command") != null) {
            String path = request.getContextPath();

            if (request.getParameter("command").equals("logout")) {
                response.sendRedirect(path);
                return;
            }
        }

        request.getRequestDispatcher(page).forward(request, response);
    }
}