package tvd.pro.studentsmanager.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tvd.pro.studentsmanager.R;

public class MainActivity extends AppCompatActivity {
    Button btnStudent, btnTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStudent = (Button) findViewById(R.id.btnStudent);
        Button btnTeacher = (Button) findViewById(R.id.btnTeacher);
//        addEvent();
        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStudenLogin = new Intent(MainActivity.this, StudentLoginActivity.class);
                startActivity(intentStudenLogin);
            }
        });
        btnTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTeacherLgogin = new Intent(MainActivity.this, TeacherLoginActivity.class);
                startActivity(intentTeacherLgogin);
            }
        });



    }

}