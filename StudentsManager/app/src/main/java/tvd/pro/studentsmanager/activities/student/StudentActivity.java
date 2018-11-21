package tvd.pro.studentsmanager.activities.student;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import tvd.pro.studentsmanager.R;

public class StudentActivity extends AppCompatActivity {

    TextView txtName,txtIdStudent,txtGender;
    ImageButton imgBtnChangePass,imgLogOut,imgnotify,imgmark;
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
        imgLogOut = findViewById(R.id.imgLogout);
        imgnotify = findViewById(R.id.imgNotify);
        imgmark = findViewById(R.id.imgScore);

        imgmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMarkStudent = new Intent(StudentActivity.this,VewScoreStudenActivity.class);
                intentMarkStudent.putExtra("sendIdStudent", getIntent().getStringExtra(StudentLoginActivity.IDSTUDENT));
                startActivity(intentMarkStudent);
            }
        });
        imgnotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNotify = new Intent(StudentActivity.this,StudentNotifyActivity.class);
                startActivity(intentNotify);
            }
        });

        imgLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences myPrefs = getSharedPreferences("Activity",
                        MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.clear();
                editor.commit();
                //AppState.getSingleInstance().setLoggingOut(true);
                setLoginState(true);
/*                Intent intent = new Intent(StudentActivity.this, StudentLoginActivity.class);
                StudentLoginActivity.loginPrefsEditor.clear();
                StudentLoginActivity.loginPrefsEditor.commit();

                startActivity(intent);*/

                finish();

            }
        });

        imgBtnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChangePassST = new Intent(StudentActivity.this, ChangePassStudentActivity.class);
                intentChangePassST.putExtra("sendIdStudent", getIntent().getStringExtra(StudentLoginActivity.IDSTUDENT));
                intentChangePassST.putExtra("sendPassWord", getIntent().getStringExtra(StudentLoginActivity.PASSWORD));

                startActivity(intentChangePassST);

            }
        });

    }
    private void getInforUser()
    {

        txtName.setText(getIntent().getStringExtra(StudentLoginActivity.STUDENTNAME));
        txtIdStudent.setText(getIntent().getStringExtra(StudentLoginActivity.IDSTUDENT));
        txtGender.setText(getIntent().getStringExtra(StudentLoginActivity.GENDER));
    }
    private void setLoginState(boolean status) {
        SharedPreferences sp = getSharedPreferences("LoginState",
                MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean("setLoggingOut", status);
        ed.commit();
    }

}

