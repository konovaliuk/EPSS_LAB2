package entities;

public class Marks {
    private long id;
    private long amount;
    private String type;
    private String description;
    private long studentId;
    private long teacherId;
    private String createdAt;
    private long disciplineId;
    private String teacherName;
    private String teacherSurname;
    private String studentName;
    private String studentSurname;
    private String disciplineTitle;

    public Marks(long id, long amount, String type, String description, long studentId,
                 long teacherId, String createdAt, long disciplineId){
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.createdAt = createdAt;
        this.disciplineId =disciplineId;
    }

    public Marks(long id, long amount, String type, String description, String createdAt, String teacherName, String teacherSurname, String disciplineTitle, String studentName, String studentSurname) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.disciplineTitle = disciplineTitle;
        this.createdAt = createdAt;

    }

    public Marks(int amount, String type, String description, int studentId, int teacherId, int disciplineId) {
      // this.id = id;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.disciplineId = disciplineId;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getAmount(){
        return amount;
    }

    public void setAmount(long amount){
        this.amount = amount;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getDescription(){
        return description;
    }

    public void setDisciplineId(String description){
        this.description = description;
    }

    public long getStudentId(){
        return studentId;
    }

    public void setStudentId(long studentId){
        this.studentId = studentId;
    }

    public long getTeacherId(){
        return teacherId;
    }

    public void setTeacherId(long teacherId){
        this.teacherId = teacherId;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public long getDisciplineId(){
        return disciplineId;
    }

    public void setDisciplineId(long disciplineId){
        this.disciplineId = disciplineId;
    }

    @Override
    public String toString(){
        if (teacherId!=0){
            return "Marks {" +
                    "id = " + id +
                    ", amount = '" + amount + '\'' +
                    ", type = '" + type + '\'' +
                    ", description = '" + description + '\'' +
                    ", student_id = '" + studentId + '\'' +
                    ", teacher_id = '" + teacherId + '\'' +
                    ", created_at ='" + createdAt + '\'' +
                    ", discipline_id ='" + disciplineId + '\'' +
                    '}';
        } else{

            return "Marks {" +
                    "id = " + id +
                    ", amount = '" + amount + '\'' +
                    ", type = '" + type + '\'' +
                    ", description = '" + description + '\'' +
                    ", student = '" + studentName + " "+studentSurname+ '\'' +
                    ", teacher = '" + teacherName + " "+teacherSurname+ '\'' +
                    ", created_at ='" + createdAt + '\'' +
                    ", discipline ='" + disciplineTitle + '\'' +
                    '}';}}

}
