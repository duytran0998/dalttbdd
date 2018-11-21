package tvd.pro.studentsmanager.activities.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import tvd.pro.studentsmanager.R;

public class StudentNotifyActivity extends AppCompatActivity {
    String[] content = {
            "Thông báo đóng Bảo hiểm Y tế sinh viên bắt buộc năm học 2018-2019",
            "Lịch thi chính thức học kỳ 1 năm học 2018-2019 (đợt 1, 2)",
            "Danh sách sinh viên và số tiền miễn giảm học phí học kỳ 1 năm học 2018-2019"

    };
    ListView lvNotify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_notify);
        lvNotify = findViewById(R.id.lvNotify);
        lvNotify.setAdapter(new ArrayAdapter<>(StudentNotifyActivity.this,
                android.R.layout.simple_list_item_1, content));



    }

}
