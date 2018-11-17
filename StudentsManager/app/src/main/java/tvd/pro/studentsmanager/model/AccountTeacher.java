package tvd.pro.studentsmanager.model;


import com.google.gson.annotations.SerializedName;

public class AccountTeacher {

    @SerializedName("idTeacher")
    private  String idTeacher;
    @SerializedName("teacherName")
    private  String teacherName;
    @SerializedName("idFaculty")
    private  String idFaculty;
    @SerializedName("userName")
    private  String userName;
    @SerializedName("passWord")
    private  String passWord;
    @SerializedName("genDer")
    private  String genDer;
    @SerializedName("error")
    private int error;

    public String getIdTeacher() {
        return idTeacher;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getIdFaculty() {
        return idFaculty;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getGenDer() {
        return genDer;
    }

    public int getError() {
        return error;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setIdFaculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setGenDer(String genDer) {
        this.genDer = genDer;
    }

    public void setError(int error) {
        this.error = error;
    }

    public AccountTeacher(String idTeacher, String teacherName, String idFaculty, String userName, String passWord, String genDer) {
        this.idTeacher = idTeacher;
        this.teacherName = teacherName;
        this.idFaculty = idFaculty;
        this.userName = userName;
        this.passWord = passWord;
        this.genDer = genDer;

    }
}
