/*

import connection.ConnectionPool;
import dao.*;
import dao.interfaces.IDisciplineDao;
import dao.interfaces.IMarksDao;
import dao.interfaces.IUserDao;
import dao.interfaces.IUserDisciplineDao;
import entities.Discipline;
import entities.Marks;
import entities.User;
import entities.UserDiscipline;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Main {

    public static void main(String arg[]){

        System.out.println("\n");
        testUserDao();
        System.out.println("\n");
        testDisciplineDao();
        System.out.println("\n");
        testUserDisciplineDao();
        System.out.println("\n");
        testMarksDao();
    }


//------------------------------------start of UserDaoTesting---------------------------------------------------------

    private static void testUserDao(){
        try{

            IUserDao userDao = DaoFactory.createUserDao();

            System.out.println("Find ALl---");
            printAll(userDao.findAll());

            System.out.println("Find by id---");
            System.out.println(userDao.findById(1).toString());

            System.out.println("save---");
            User user1 = new User("andyuyube@gmail.com", "aapas321word", "student", "aan312ame", "aasur312name");
            userDao.save(user1);


            System.out.println("update---");
            userDao.update(17, user1 );

            System.out.println("delete---");
            userDao.delete(28);
            printAll(userDao.findAll());
            userDao.closeConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
//------------------------------------end of UserDaoTesting---------------------------------------------------------

//-------------------------------------start of DisciplineDaoTesting---------------------------------------------------------

    private static void testDisciplineDao(){

        try{

            IDisciplineDao disciplineDao = DaoFactory.createDisciplineDao();

            System.out.println("Find ALl---");
            printAll(disciplineDao.findAll());

            System.out.println("Find by id---");
            System.out.println(disciplineDao.findById(1).toString());

            System.out.println("save---");
            Discipline discipline1 = new Discipline("iq");
            disciplineDao.save(discipline1);


            System.out.println("update---");
            disciplineDao.update(6, discipline1 );

            System.out.println("delete---");
            disciplineDao.delete(13);
            printAll(disciplineDao.findAll());

            disciplineDao.closeConnection();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
//------------------------------------end of DisciplineDaoTesting---------------------------------------------------------

//-------------------------------------start of UserDisciplineDaoTesting---------------------------------------------------------
    private static void testUserDisciplineDao(){
    try{
        IUserDisciplineDao userDisciplineDao = DaoFactory.createUserDisciplineDao();

      System.out.println("\n Find ALl---");
        printAll(userDisciplineDao.findAll());
        System.out.println("\n Find ALl NO DIGITS---");
        printAll(userDisciplineDao.findAllNoDigits());
        System.out.println("\n Find ALl USERS DISCIPLINES---");
        printAll(userDisciplineDao.findAllUserDisciplines(16));
        System.out.println("\n Find ALl DISCIPLINE USERS---");
        printAll(userDisciplineDao.findAllDisciplineUsers(1));
        System.out.println("\n Find BY ID---");
        printAll(userDisciplineDao.findById(5));
        System.out.println("\n Find BY ID NO DIGITS---");
        printAll(userDisciplineDao.findByIdNoDigits(5));
        System.out.println("\n save---");
        UserDiscipline userDiscipline = new UserDiscipline(17, 1);
        userDisciplineDao.save(userDiscipline);
        System.out.println("\n update---");
        userDisciplineDao.update(6, userDiscipline );


        System.out.println("delete---");
        userDisciplineDao.delete(7);
        printAll(userDisciplineDao.findAll());

        userDisciplineDao.closeConnection();

    } catch (SQLException e){
        e.printStackTrace();
    }
}
//-------------------------------------end of UserDisciplineDaoTesting---------------------------------------------------------

//-------------------------------------start of MarksDaoTesting---------------------------------------------------------
private static void testMarksDao() {
    try{
        IMarksDao MarksDao = DaoFactory.createMarksDao();
        System.out.println("\n Find ALl---");
        printAll(MarksDao.findAll());
        System.out.println("\n Find ALl NO DIGITS---");
        printAll(MarksDao.findAllNoDigits());
        System.out.println("\n Find ALl USER MARKS---");
        printAll(MarksDao.findAllUserMarks(1));
        System.out.println("\n Find ALl DISCIPLINE MARKS---");
        printAll(MarksDao.findAllDisciplineMarks(9));
        System.out.println("\n Find BY ID---");
        printAll(MarksDao.findById(2));
        System.out.println("\n Find BY ID NO DIGITS---");
        printAll(MarksDao.findByIdNoDigits(2));
        System.out.println("\n save---");
        Marks mark = new Marks(10, "homework", "gj", 16, 1, 9);
        MarksDao.save(mark);
        System.out.println("\n update---");
        MarksDao.update(3, mark );
        System.out.println("delete---");
        MarksDao.delete(2);
        printAll(MarksDao.findAll());
    } catch (SQLException e){
        e.printStackTrace();
    }
}
//-------------------------------------end of MarksDaoTesting---------------------------------------------------------


    private static void printAll(List resultList){
        resultList.forEach((result) -> {
            System.out.println(result.toString());
        });

    }


}

*/