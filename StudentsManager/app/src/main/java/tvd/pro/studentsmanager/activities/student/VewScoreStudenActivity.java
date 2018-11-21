package tvd.pro.studentsmanager.activities.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tvd.pro.studentsmanager.R;

import tvd.pro.studentsmanager.adapter.ScoreAdapter;
import tvd.pro.studentsmanager.model.modelstudent.Score;
import tvd.pro.studentsmanager.nextwork.GetScoreRequest;
import tvd.pro.studentsmanager.nextwork.SeverRequest;

public class VewScoreStudenActivity extends AppCompatActivity {
    ArrayList<Score> arrViewScore;
    ListView lv_view_score_studnet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vew_core_studen);
        //get view
        lv_view_score_studnet=findViewById(R.id.lv_view_score_studnet);
        //----------------------------------------------------//
        ViewScoreStudent();



    }




    private void ViewScoreStudent(){

        String MASV = getIntent().getStringExtra("sendIdStudent");
        Map<String, String> parameter = new HashMap<>();
        parameter.put("idStudent",MASV);
        GetScoreRequest request = new GetScoreRequest(new SeverRequest.SeverRequestListener() {
            @Override
            public void completed(Object obj) {
                if (obj != null) {
                    arrViewScore= (ArrayList<Score>) obj;

                    ScoreAdapter adapter=new ScoreAdapter(getBaseContext(),R.layout.dong_get_view_score_student_adapter,arrViewScore);
                    lv_view_score_studnet.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    //ERROR
                    Toast.makeText(getBaseContext(),"Excute Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
        request.execute(parameter);
    }

}
