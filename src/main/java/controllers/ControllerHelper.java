package controllers;

import commands.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class ControllerHelper {

    private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<>();


    private ControllerHelper() {
        commands.put("login", new CommandLogin());
        commands.put("getAllUsers", new CommandGetAllUsers());
        commands.put("getUserDisciplines", new CommandGetUserDisciplines());
        commands.put("logout", new CommandLogout());
        commands.put("addUser", new CommandAddUser());
        commands.put("addDiscipline", new CommandAddDiscipline());
        commands.put("getAllDisciplines", new CommandGetAllDisciplines());
        commands.put("addDisciplineForUser", new CommandAddDisciplineForUser());
        commands.put("addMark", new CommandAddMark());
        commands.put("getUserMarksForDiscipline", new CommandGetUserMarksForDiscipline());
        commands.put("deleteMark", new CommandDeleteMark());
    }

    public ICommand getCommand(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        System.out.println("Executing command: "+commandName);
        ICommand command = commands.get(commandName);

        HttpSession session = request.getSession();


        String username = (String) session.getAttribute("username");

        if (command == null && username == null) {
            session.setAttribute("registerStatus", "GoTo");
            command = new CommandGoToLogin();
        }
        if (command == null)
            command = new CommandMissing();

        if (command.equals(username))
            return command;

        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }

        return instance;
    }


}