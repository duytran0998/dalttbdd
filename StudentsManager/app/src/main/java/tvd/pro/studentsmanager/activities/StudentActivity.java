package tvd.pro.studentsmanager.activities;

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
    ImageButton imgBtnChangePass,imgLogOut;
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
                Intent intent = new Intent(StudentActivity.this,
                        TeacherLoginActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setAction(null);
                startActivity(intent);

            }
        });

        imgBtnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChangePassST = new Intent(StudentActivity.this, ChangePassStudentActivity.class);
                intentChangePassST.putExtra("sendIdStudent", getIntent().getStringExtra(StudentLoginActivity.IDSTUDENT));
                intentChangePassST.putExtra("sendPassWord", getIntent().getStringExtra(StudentLoginActivity.PASSWORD));

                startActivity(intentChangePassST);
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
    private void setLoginState(boolean status) {
        SharedPreferences sp = getSharedPreferences("LoginState",
                MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean("setLoggingOut", status);
        ed.commit();
    }
    public void onBackPressed() {
        Intent intent=new Intent(StudentActivity.this,StudentLoginActivity.class);
        startActivity(intent);
        finish();
    }
}

