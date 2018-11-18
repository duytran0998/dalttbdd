package tvd.pro.studentsmanager.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import tvd.pro.studentsmanager.model.AccountStudent;
import tvd.pro.studentsmanager.R;

public class StudentActivity extends AppCompatActivity {

    TextView txtName,txtIdStudent,txtGender;
    ImageButton imgBtnChangePass;
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
        txtGender=findViewById(R.id.txtGender);
        imgBtnChangePass=findViewById(R.id.imgChangepassword);

        imgBtnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChangePass = new Intent(StudentActivity.this, ChangePassStudent.class);
/*                intentChangePass.putExtra("sendIdStudent", AccountStudent.idStudent);
                intentChangePass.putExtra("sendPassWord", AccountStudent.passWord);*/

                startActivity(intentChangePass);
                finish();
            }
        });

    }
    private void getInforUser()
    {

        txtName.setText(getIntent().getStringExtra(StudentLoginActivity.STUDENTNAME));
        txtIdStudent.setText(getIntent().getStringExtra(StudentLoginActivity.IDSTUDENT));
        txtGender.setText(getIntent().getStringExtra(StudentLoginActivity.GENDER));
    }
    public void onBackPressed() {
        Intent intent=new Intent(StudentActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}

