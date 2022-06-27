package entities;

public class Discipline {
    private long id;
    private String title;

    public Discipline(long id, String title){
        this.id = id;
        this.title = title;
    }

    public Discipline() {

    }

    public Discipline(String title) {
        this.title = title;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        return "Discipline {" +
                "id = " + id +
                ", title = '" + title + '\'' +
                '}';}
}
