package tvd.pro.studentsmanager.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Subject {

    @SerializedName("idTeacher")
    private int idTeacher;
    @SerializedName("idSubject")
    private int idSubject;
    @SerializedName("subjectName")
    private String subjectName;
    @SerializedName("note")
    private String note;

    public Subject(int idTeacher, int idSubject, String subjectName, String note) {
        this.idTeacher = idTeacher;
        this.idSubject = idSubject;
        this.subjectName = subjectName;
        this.note = note;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getNote() {
        return note;
    }
}
