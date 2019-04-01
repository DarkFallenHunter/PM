package ivbo02153.demo.model;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String secondName;
    private int studyGroupId;

    public Student(int id, String surname, String name, String secondName, int studyGroupId) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.studyGroupId = studyGroupId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getStudyGroupId() {
        return this.studyGroupId;
    }

    public void setStudyGroupId(int studyGroupId) {
        this.studyGroupId = studyGroupId;
    }
}
