package tvd.pro.studentsmanager.model;

public class ScoreStudent {

    private int idStudent;
    private String nameStudent;
    private float score;

    public int getIdStudent() {
        return idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public float getScore() {
        return score;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public ScoreStudent(int idStudent, String nameStudent, float score) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.score = score;
    }
}
