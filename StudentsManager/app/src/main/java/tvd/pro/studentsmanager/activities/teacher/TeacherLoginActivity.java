package tvd.pro.studentsmanager.activities.teacher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import tvd.pro.studentsmanager.R;
import tvd.pro.studentsmanager.model.modelteacher.AccountTeacher;
import tvd.pro.studentsmanager.nextwork.SeverRequest;
import tvd.pro.studentsmanager.nextwork.TeacherLoginRequest;


public class TeacherLoginActivity extends AppCompatActivity {
    EditText edtAccount, edtPassword;
    Button btnLogin;
    CheckBox saveLoginCheckBox;

    private SharedPreferences loginPreferences;
    public static SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    public static final String TEACHERNAME="f";
    public static final String IDFACULTY="e";
    public static final String AGENDER="Nam";
    public static final String IDTEACHER="c";
    public static final String PASSWORD="a";
    public static final String USERNAME="b";
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
                final String username = edtAccount.getText().toString();
                final String password = edtPassword.getText().toString();
                //truyen tham so vao
                Map<String, String> parameter = new HashMap<>();
                parameter.put("username", username);
                parameter.put("password", password);

                TeacherLoginRequest request= new TeacherLoginRequest(new SeverRequest.SeverRequestListener() {
                    @Override
                    public void completed(Object obj) {
                        if (obj != null) {
                            AccountTeacher tc = (AccountTeacher) obj;

                            if (AccountTeacher.error == 0) {

                                Intent tec_intent = new Intent(TeacherLoginActivity.this, TeacherActivity.class);
                                tec_intent.putExtra(TEACHERNAME, tc.getTeacherName());
                                tec_intent.putExtra(IDTEACHER, tc.getIdTeacher());
                                tec_intent.putExtra(AGENDER, tc.getGenDer());
                                tec_intent.putExtra(USERNAME, tc.getUserName());
                                tec_intent.putExtra(IDTEACHER, tc.getIdTeacher());
                                tec_intent.putExtra(PASSWORD, password);
                                startActivity(tec_intent);

                            }


                        }
                        else {
                            if (AccountTeacher.error==-1) {
                                ShowMessage(getBaseContext(), "There was an error while processing request. Please try again later.");
                            } else {
                                ShowMessage(getBaseContext(), "Username or Password is wrong.");
                            }
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

    @Override
    protected void onRestart() {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
            super.onRestart();
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








}
