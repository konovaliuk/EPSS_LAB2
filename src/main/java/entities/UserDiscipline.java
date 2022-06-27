package entities;

public class UserDiscipline {
    private long id;
    private long userId;
    private long disciplineId;
    private String userName;
    private String disciplineTitle;
    private String userSurname;
    private String userRole;

    public UserDiscipline(long id, long userId, long disciplineId){
        this.id = id;
        this.userId = userId;
        this.disciplineId = disciplineId;
    }
    public UserDiscipline(long id, String userName, String userSurname, String userRole, String disciplineTitle){
        this.id = id;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userRole = userRole;
        this.disciplineTitle = disciplineTitle;

    }

    public UserDiscipline(int userId, int disciplineId) {
        this.userId = userId;
        this.disciplineId = disciplineId;
    }


    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getUserId(){
        return userId;
    }

    public void setUserId(long userId){
        this.userId = userId;
    }

    public long getDisciplineId(){
        return disciplineId;
    }

    public void setDisciplineId(long disciplineId){
        this.disciplineId = disciplineId;
    }

    @Override
    public String toString(){
        if (userId!= 0){
            return "UserDiscipline {" +
                    "id = " + id +
                    ", user = '" + userId + '\'' +
                    ", discipline ='" + disciplineId + '\'' +
                    '}';
        } else{

        return "UserDiscipline {" +
                "id = " + id +
                ", user = '" + userName + " " + userSurname + '\'' +
                ", userRole ='" + userRole + '\'' +
                ", Discipline title ='" + disciplineTitle + '\'' +
                '}';}}
}
