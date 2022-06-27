package entities;

public class User {
    private long id;
    private String email;
    private String password;
    private String role;
    private String name;
    private String surname;

    public User(long id, String email, String password, String role, String name, String surname){
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
    }
    public User( String email, String password, String role, String name, String surname){
        //this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
    }

    public User() {

    }


    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }



    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    @Override
    public String toString(){
        return "User {" +
                "id = " + id +
                ", email = '" + email + '\'' +
                ", password ='" + password + '\'' +
                ", role = '" + role + '\'' +
                ", name ='" + name + '\'' +
                ", surname ='" + surname + '\'' +
                '}';}

    public String getPasswordHash() {
        return password;
    }
}
