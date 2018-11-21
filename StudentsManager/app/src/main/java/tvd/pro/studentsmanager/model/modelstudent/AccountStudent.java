package tvd.pro.studentsmanager.model.modelstudent;


import com.google.gson.annotations.SerializedName;

public class AccountStudent {

    @SerializedName("idStudent")
    private String idStudent;
    @SerializedName("studentName")
    private String studentName;
    @SerializedName("studentAddress")
    private String studentAddress;
    @SerializedName("userName")
    private String userName;
    @SerializedName("passWord")
    private String passWord;
    @SerializedName("genDer")
    private String genDer;
    @SerializedName("idClass")
    private int idClass;
    @SerializedName("error")
    public static int error;

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String IdStudent) {
        this.idStudent = IdStudent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGenDer() {
        return genDer;
    }

    public void setGenDer(String genDer) {
        this.genDer = genDer;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }





    public AccountStudent(String idStudent, String studentName, String studentAddress, String userName, String passWord, String genDer, int idClass) {
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.userName = userName;
        this.passWord = passWord;
        this.genDer = genDer;
        this.idClass = idClass;
    }


}
