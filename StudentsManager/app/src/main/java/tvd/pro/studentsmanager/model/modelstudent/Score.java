package tvd.pro.studentsmanager.model.modelstudent;

public class Score {


    private int idStudent;
    private String subjectName;
    private float score;

    public Score(int idStudent, String subjectName, float score) {
        this.idStudent = idStudent;
        this.subjectName = subjectName;
        this.score = score;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public float getScore() {
        return score;
    }


}
