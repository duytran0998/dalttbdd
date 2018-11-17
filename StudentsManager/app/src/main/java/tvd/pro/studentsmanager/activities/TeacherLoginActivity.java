package tvd.pro.studentsmanager.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;
import tvd.pro.studentsmanager.R;
import tvd.pro.studentsmanager.model.AccountTeacher;
import tvd.pro.studentsmanager.nextwork.SeverRequest;
import tvd.pro.studentsmanager.nextwork.TeacherLoginRequest;


public class TeacherLoginActivity extends AppCompatActivity {
    EditText edtAccount, edtPassword;
    Button btnLogin;
    CheckBox saveLoginCheckBox;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    public static final String TEACHERNAME=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);
        /*addEvent() sử dụng la crash app */
        edtAccount =  findViewById(R.id.edtAccount);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        saveLoginCheckBox = findViewById(R.id.saveLoginCheckBox);

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            edtAccount.setText(loginPreferences.getString("username", ""));
            edtPassword.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = edtAccount.getText().toString();
                String password = edtPassword.getText().toString();
                //truyen tham so vao
                Map<String, String> parameter = new HashMap<>();
                parameter.put("username", username);
                parameter.put("password", password);

                TeacherLoginRequest request= new TeacherLoginRequest(new SeverRequest.SeverRequestListener() {
                    @Override
                    public void completed(Object obj) {
                        AccountTeacher tc= (AccountTeacher) obj;
                       switch (tc.getError()){
                           case 0:
                               Intent tec_intent=new Intent(TeacherLoginActivity.this,TeacherActivity.class);
                               tec_intent.putExtra(TEACHERNAME,tc.getTeacherName());
/*                               tec_intent.putExtra("idFaculty",tc.getIdFaculty());
                               tec_intent.putExtra("genDer",tc.getGenDer());
                               tec_intent.putExtra("idTeacher",tc.getIdTeacher());
                               tec_intent.putExtra("passWord",tc.getPassWord());*/

                               startActivity(tec_intent);
                               finish();
                       }
                    }
                });
                request.execute(parameter);


                if (saveLoginCheckBox.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("username", username);
                    loginPrefsEditor.putString("password", password);
                    loginPrefsEditor.commit();

                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }

            }
        });


    }

    public void ShowMessage(final Context context, final String msg) {
        if (context != null && msg != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {

                @Override
                public void run() {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



    @Override
    public void onBackPressed() {
        Intent intent=new Intent(TeacherLoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onDestroy() {

        super.onDestroy();

    }



}
