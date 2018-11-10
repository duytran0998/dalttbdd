package tvd.pro.studentsmanager.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import tvd.pro.studentsmanager.model.AccountStudent;
import tvd.pro.studentsmanager.R;

public class StudentActivity extends AppCompatActivity {

    TextView txtName,txtIdStudent,txtGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        getView();
        getInforUser();
    }
    private void getView() {
        txtName=findViewById(R.id.txtUserName);
        txtIdStudent=findViewById(R.id.txtIdstudent);
        txtGender=findViewById(R.id.txtGedenr);

    }
    private void getInforUser()
    {
        txtName.setText(AccountStudent.studentName);
        txtIdStudent.setText(AccountStudent.idStudent);
        txtGender.setText(AccountStudent.genDer);

    }
}
