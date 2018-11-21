package tvd.pro.studentsmanager.activities.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tvd.pro.studentsmanager.R;
import tvd.pro.studentsmanager.adapter.ClassAdapter;
import tvd.pro.studentsmanager.model.modelstudent.ScoreStudent;
import tvd.pro.studentsmanager.adapter.ScoreStudentAdapter;
import tvd.pro.studentsmanager.model.Select;
import tvd.pro.studentsmanager.model.Subject;
import tvd.pro.studentsmanager.adapter.SubjectAdapter;
import tvd.pro.studentsmanager.model.modelteacher.TeacherClass;
import tvd.pro.studentsmanager.nextwork.GetClassReQuest;
import tvd.pro.studentsmanager.nextwork.GetSubjectRequest;
import tvd.pro.studentsmanager.nextwork.ScoreStudentRequest;
import tvd.pro.studentsmanager.nextwork.SeverRequest;

public class ViewTeacherScoreActivity extends AppCompatActivity {
    Spinner spinner_subject;
    ArrayList<Subject> arrSubject;
    Spinner spinner_class;
    ArrayList<TeacherClass> arrTeacherClass;
    ArrayList<ScoreStudent> arrScoreStudent;
    ListView lv_score_studnet;


    public  static String STUDENTID="mahocsinh";
    public  static  String STUDENTNAME="tenhocsinh";
    public  static  String SUBJECTID="mamonhoc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teacher_score);
        //get view
        spinner_subject  = (Spinner) findViewById(R.id.spin_subject);
        spinner_class=findViewById(R.id.spin_class);
        lv_score_studnet=findViewById(R.id.lv_score_student);
        //----------------------------------------------------//
             if(Select.IDCLASS!=null&&Select.MAMONHOC!= 0)
             ScoreStudent(Select.IDCLASS,String.valueOf(Select.MAMONHOC));
             getSubject("8");


        }

    @Override
    protected void onRestart() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        super.onRestart();
    }

    private void getSubject(String idTeacher){
         Map<String, String> parameter = new HashMap<>();
         parameter.put("idTeacher", idTeacher);

         GetSubjectRequest request = new GetSubjectRequest(new SeverRequest.SeverRequestListener(){
             @Override
             public void completed(Object obj) {
                 if (obj != null) {
                     arrSubject= (ArrayList<Subject>) obj;

                     SubjectAdapter adapter=new SubjectAdapter(getBaseContext(),R.layout.dong_subject,arrSubject);
                     spinner_subject.setAdapter(adapter);
                     adapter.notifyDataSetChanged();
                     spinner_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                         @Override
                         public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                              Select.MAMONHOC = arrSubject.get(i).getIdSubject();
                             ViewTeacherScoreActivity.this.getClass(String.valueOf(arrSubject.get(i).getIdSubject()),"8");

                         }

                         @Override
                         public void onNothingSelected(AdapterView<?> adapterView) {

                         }
                     });


                 } else {
                     //ERROR
                     Toast.makeText(getBaseContext(),"lOI",Toast.LENGTH_SHORT).show();
                 }
             }
         });
         request.execute(parameter);
     }

     private void subJectItemClick(){

     }

     private void getClass(String idSubject,String idTeacher){
         Map<String, String> parameter = new HashMap<>();
         parameter.put("idSubject", idSubject);
         parameter.put("idTeacher", idTeacher);
         GetClassReQuest request = new GetClassReQuest(new SeverRequest.SeverRequestListener() {
             @Override
             public void completed(Object obj) {
                 if (obj != null) {
                     arrTeacherClass= (ArrayList<TeacherClass>) obj;

                     ClassAdapter adapter=new ClassAdapter(getBaseContext(),R.layout.dong_class,arrTeacherClass);
                     spinner_class.setAdapter(adapter);
                     adapter.notifyDataSetChanged();
                     spinner_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                         @Override
                         public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                             ScoreStudent(String.valueOf(arrTeacherClass.get(i).getIdClass()),String.valueOf(Select.MAMONHOC));
                              Select.IDCLASS=String.valueOf(arrTeacherClass.get(i).getIdClass());
                         }

                         @Override
                         public void onNothingSelected(AdapterView<?> adapterView) {

                         }
                     });



                 } else {
                     //ERROR
                     Toast.makeText(getBaseContext(),"lOI",Toast.LENGTH_SHORT).show();
                 }
             }
         });
         request.execute(parameter);
     }

    private void ScoreStudent(String idClass,String idSubject){
        Map<String, String> parameter = new HashMap<>();
        parameter.put("idClass", idClass);
        parameter.put("idSubject", idSubject);
        ScoreStudentRequest request = new ScoreStudentRequest(new SeverRequest.SeverRequestListener() {
            @Override
            public void completed(Object obj) {
                if (obj != null) {
                    arrScoreStudent= (ArrayList<ScoreStudent>) obj;

                    ScoreStudentAdapter adapter=new ScoreStudentAdapter(getBaseContext(),R.layout.lv_items_cores,arrScoreStudent);
                    lv_score_studnet.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } else {
                    //ERROR
                    Toast.makeText(getBaseContext(),"lOI",Toast.LENGTH_SHORT).show();
                }
            }
        });
        request.execute(parameter);
    }

    private void onClickItemClass(){
        spinner_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               /* ScoreStudent(String.valueOf(arrTeacherClass.get(i).getIdClass()));*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
