package tvd.pro.studentsmanager.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import tvd.pro.studentsmanager.model.AccountTeacher;
import tvd.pro.studentsmanager.R;

public class TeacherActivity extends AppCompatActivity {

    TextView txtTeacherName,txtIdFaculty,txtGender;
    ImageButton imgBtnChangePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        getView();
        getInforUser();

    }
    private void getView() {
        txtTeacherName=findViewById(R.id.txtUserName);
        txtIdFaculty=findViewById(R.id.txtIdFaculty);
        txtGender=findViewById(R.id.txtGedenr);
        imgBtnChangePass=findViewById(R.id.imgChangepassword);

        imgBtnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChangePass = new Intent(TeacherActivity.this, ChangePassTeacher.class);
               /* intentChangePass.putExtra("sendTeacher", AccountTeacher.idTeacher);
                intentChangePass.putExtra("sendPassWord", AccountTeacher.passWord);*/

                startActivity(intentChangePass);
                finish();
            }
        });

    }
    private void getInforUser()
    {

        final Intent intent = getIntent();
        String s = intent.getStringExtra(TeacherLoginActivity.TEACHERNAME);
        txtTeacherName.setText(s);

/*        txtIdFaculty.setText(tc.getIdFaculty());
        txtGender.setText(tc.getGenDer());*/

    }
    public void onBackPressed() {
        Intent intent=new Intent(TeacherActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}

