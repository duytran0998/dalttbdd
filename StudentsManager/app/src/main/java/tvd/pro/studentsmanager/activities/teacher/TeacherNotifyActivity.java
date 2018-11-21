package tvd.pro.studentsmanager.activities.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import tvd.pro.studentsmanager.R;

public class TeacherNotifyActivity extends AppCompatActivity {
    String[] content = {
            "Thông báo công văn về việc ủy quyền ký thừa ủy quyền cho Trưởng Khoa Quốc tế và Trưởng Khoa Ngoại ngữ",
            "Thông báo công văn về việc tuyển sinh đào tạo thạc sĩ tại Nhật Bản năm 2019",
            "Thông báo công văn về việc cử viên chức dự thi thăng hạng lên chuyên viên chính năm 2018"

    };
    ListView lvNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_notify);
        lvNotify = findViewById(R.id.lvNotify);
        lvNotify.setAdapter(new ArrayAdapter<>(TeacherNotifyActivity.this,
                android.R.layout.simple_list_item_1, content));

    }
}
