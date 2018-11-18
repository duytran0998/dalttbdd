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

    TextView txtTeacherName,txtIdTeacher,txtGender;
    ImageButton imgBtnChangePass;
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

        imgBtnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChangePass = new Intent(TeacherActivity.this, ChangePassTeacherActivity.class);
                intentChangePass.putExtra("sendTeacher", getIntent().getStringExtra(TeacherLoginActivity.USERNAME));
                intentChangePass.putExtra("sendPassWord", getIntent().getStringExtra(TeacherLoginActivity.PASSWORD));
                startActivity(intentChangePass);
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
    public void onBackPressed() {
        Intent intent=new Intent(TeacherActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}

