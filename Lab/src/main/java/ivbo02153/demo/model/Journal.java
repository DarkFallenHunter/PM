package ivbo02153.demo.model;

public class Journal {
    private int id;
    private int studentId;
    private int studyPlanId;
    private boolean inTime;
    private int count;
    private int markId;

    public Journal(int id, int studentId, int studyPlanId, boolean inTime, int count, int markId) {
        this.id = id;
        this.studentId = studentId;
        this.studyPlanId = studyPlanId;
        this.inTime = inTime;
        this.count = count;
        this.markId= markId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudyPlanId() {
        return this.studyPlanId;
    }

    public void setStudyPlanId(int studyPlanId) {
        this.studyPlanId = studyPlanId;
    }

    public boolean getInTime() {
        return this.inTime;
    }

    public void setInTime(boolean inTime) {
        this.inTime = inTime;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMarkId() {
        return this.markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }
}