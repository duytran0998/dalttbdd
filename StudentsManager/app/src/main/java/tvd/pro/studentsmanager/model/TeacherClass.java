package tvd.pro.studentsmanager.model;

public class TeacherClass {

    private int idClass;
    private int idTeacher;
    private int idSubject;
    private String className;
    private String note;

    public int getIdClass() {
        return idClass;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public int getIdSUbject() {
        return idSubject;
    }

    public String getClassName() {
        return className;
    }

    public String getNote() {
        return note;
    }

    public TeacherClass(int idClass, int idTeacher, int idSUbject, String className, String note) {
        this.idClass = idClass;
        this.idTeacher = idTeacher;
        this.idSubject = idSUbject;
        this.className = className;
        this.note = note;
    }
}
