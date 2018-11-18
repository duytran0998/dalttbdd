package tvd.pro.studentsmanager.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import tvd.pro.studentsmanager.model.AccountTeacher;
import tvd.pro.studentsmanager.R;

public class TeacherActivity extends AppCompatActivity {

    TextView txtTeacherName,txtIdTeacher,txtGender;
    ImageButton imgBtnChangePass,imgLogOut;
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
        txtGender=findViewById(R.id.txtGender);
        imgBtnChangePass=findViewById(R.id.imgChangepassword);
        imgLogOut=findViewById(R.id.imgLogout);

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
                Intent intent = new Intent(TeacherActivity.this,
                        TeacherLoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });


        imgBtnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChangePassTC = new Intent(TeacherActivity.this, ChangePassTeacherActivity.class);
                intentChangePassTC.putExtra("sendIdTeacher", getIntent().getStringExtra(TeacherLoginActivity.IDTEACHER));
                intentChangePassTC.putExtra("sendPassWord", getIntent().getStringExtra(TeacherLoginActivity.PASSWORD));
                startActivity(intentChangePassTC);
                finish();
            }
        });

    }
    private void getInforUser()
    {


        txtTeacherName.setText(getIntent().getStringExtra(TeacherLoginActivity.TEACHERNAME));
        txtIdTeacher.setText(getIntent().getStringExtra(TeacherLoginActivity.IDTEACHER));
        txtGender.setText(getIntent().getStringExtra(TeacherLoginActivity.GENDER));


    }
    private void setLoginState(boolean status) {
        SharedPreferences sp = getSharedPreferences("LoginState",
                MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean("setLoggingOut", status);
        ed.commit();
    }
    public void onBackPressed() {
        Intent intent=new Intent(TeacherActivity.this,TeacherLoginActivity.class);
        startActivity(intent);
        finish();
    }
}

