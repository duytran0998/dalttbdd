package tvd.pro.studentsmanager.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import tvd.pro.studentsmanager.R;

public class TeacherActivity extends AppCompatActivity {

    TextView txtTeacherName,txtIdTeacher,txtGender;
    ImageButton imgBtnChangePass,imgLogOut,imgNotifyTC,imgStudy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        getView();
        getInforUser();

    }
    private void getView() {
        txtTeacherName=findViewById(R.id.txtTeacherName);
        txtIdTeacher=findViewById(R.id.txtIdTeacher);
        txtGender=findViewById(R.id.txtGenderGV);
        imgBtnChangePass=findViewById(R.id.imgChangepassword);
        imgLogOut=findViewById(R.id.imgLogout);
        imgNotifyTC=findViewById(R.id.imgNotify);
        imgStudy=findViewById(R.id.imgStudy);


        imgStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStudy = new Intent(TeacherActivity.this,ChamDiemActivity.class);
                startActivity(intentStudy);
            }
        });


        imgNotifyTC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intentNotifyTC = new Intent(TeacherActivity.this,TeacherNotify.class);
                startActivity(intentNotifyTC);
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
              /*  Intent intent = new Intent(TeacherActivity.this,
                        TeacherLoginActivity.class);
                TeacherLoginActivity.loginPrefsEditor.clear();
                TeacherLoginActivity.loginPrefsEditor.commit();
                startActivity(intent);*/
                finish();

            }
        });


        imgBtnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChangePassTC = new Intent(TeacherActivity.this, ChangePassTeacherActivity.class);
                intentChangePassTC.putExtra("sendIdTeacher", getIntent().getStringExtra(TeacherLoginActivity.IDTEACHER));
                intentChangePassTC.putExtra("sendPassWord", getIntent().getStringExtra(TeacherLoginActivity.PASSWORD));
                startActivity(intentChangePassTC);

            }
        });

    }
    private void getInforUser()
    {

        txtTeacherName.setText(getIntent().getStringExtra(TeacherLoginActivity.TEACHERNAME));
        txtIdTeacher.setText(getIntent().getStringExtra(TeacherLoginActivity.IDTEACHER));
        txtGender.setText(getIntent().getStringExtra(TeacherLoginActivity.AGENDER));


    }
    private void setLoginState(boolean status) {
        SharedPreferences sp = getSharedPreferences("LoginState",
                MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean("setLoggingOut", status);
        ed.commit();
    }

}

