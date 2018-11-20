package tvd.pro.studentsmanager.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import tvd.pro.studentsmanager.R;
import tvd.pro.studentsmanager.model.ScoreStudentAdapter;
import tvd.pro.studentsmanager.nextwork.InputScoreRequest;
import tvd.pro.studentsmanager.nextwork.SeverRequest;
import tvd.pro.studentsmanager.nextwork.UpdateScoreRequest;

public class InputScoreStudent extends AppCompatActivity {
   private EditText edtMaSV;
   private EditText edtTenSV;
   private EditText edtMaMonHoc;
   private EditText edtScore;
   private Button btnNhapDiem,btnSuaDiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_score_student);

        getView();
        getIntens();
        setData();
        addEvents();
    }


    private void getView() {
        edtMaSV=findViewById(R.id.edt_masv);
        edtTenSV=findViewById(R.id.edt_tensv);
        edtMaMonHoc=findViewById(R.id.edt_mamonhoc);
        edtScore=findViewById(R.id.edt_score);
        btnNhapDiem=findViewById(R.id.btnNhapDiem);
        btnSuaDiem=findViewById(R.id.btnSuaDiem);




    }

    private void getIntens() {
        Intent intent =getIntent();

        edtMaSV.setText(intent.getStringExtra(ScoreStudentAdapter.STUDENTID));
        edtTenSV.setText(intent.getStringExtra(ScoreStudentAdapter.STUDENTNAME));
        edtMaMonHoc.setText(intent.getStringExtra(ScoreStudentAdapter.SUBJECTID));
    }

    private void setData() {
    }
    private void addEvents(){





        btnNhapDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Score = edtScore.getText().toString().trim();
                Float score = Float.parseFloat(Score);


                    if(0>score||score>10){
                        Toast.makeText(getBaseContext(),"Diem khong hop le!",Toast.LENGTH_SHORT).show();
                        return;
                    }


                if(edtScore!=null){

                  String idStudent=edtMaSV.getText().toString();
                  String idSubject=edtMaMonHoc.getText().toString();
                  String diem=edtScore.getText().toString();
                    final Map<String, String> parameter = new HashMap<>();
                    parameter.put("idStudent", idStudent);
                    parameter.put("idSubject", idSubject);
                    parameter.put("score",diem);
                    final InputScoreRequest request=new InputScoreRequest(new SeverRequest.SeverRequestListener() {
                        @Override
                        public void completed(Object obj) {
                             if(obj!=null){
                                     int mess=(int) obj;
                                     if(mess==0){


                                         finish();

                                     }
                             }
                             else{
                                 Toast.makeText(getBaseContext(),"Sever error!",Toast.LENGTH_SHORT).show();
                             }

                        }
                    });
                    request.execute(parameter);

                }else{
                    Toast.makeText(InputScoreStudent.this, "Điểm nhập vào không đúng.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnSuaDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Score = edtScore.getText().toString().trim();
                Float score = Float.parseFloat(Score);


                if(0>score||score>10){
                    Toast.makeText(getBaseContext(),"Diem khong hop le!",Toast.LENGTH_SHORT).show();
                    return;
                }


                if(edtScore!=null){

                    String idStudent=edtMaSV.getText().toString();
                    String idSubject=edtMaMonHoc.getText().toString();
                    String diem=edtScore.getText().toString();
                    final Map<String, String> parameter = new HashMap<>();
                    parameter.put("idStudent", idStudent);
                    parameter.put("idSubject", idSubject);
                    parameter.put("score",diem);
                    final UpdateScoreRequest request=new UpdateScoreRequest(new SeverRequest.SeverRequestListener() {
                        @Override
                        public void completed(Object obj) {
                            if(obj!=null){
                                int mess=(int) obj;
                                if(mess==0){


                                    finish();

                                }
                            }
                            else{
                                Toast.makeText(getBaseContext(),"Sever error!",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    request.execute(parameter);

                }else{
                    Toast.makeText(InputScoreStudent.this, "Điểm nhập vào không đúng.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
