package tvd.pro.studentsmanager.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import tvd.pro.studentsmanager.model.AccountStudent;
import tvd.pro.studentsmanager.R;


public class TeacherLoginActivity extends AppCompatActivity {
    EditText edtAccount, edtPassword;
    Button btnLogin;
    CheckBox saveLoginCheckBox;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);
        /*addEvent() su dung la crash app */
        final EditText edtAccount = (EditText) findViewById(R.id.edtAccount);
        final EditText edtPassword = (EditText) findViewById(R.id.edtPassword);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final CheckBox saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
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
                new AccessSever(username, password).execute();


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

    public class AccessSever extends AsyncTask<String, Void, String> {
        Response response;
        OkHttpClient client = new OkHttpClient.Builder().build();
        String user, password;


        public AccessSever(String user, String password) {
            this.user = user;
            this.password = password;
        }

        @Override
        protected String doInBackground(String... strings) {

            RequestBody requestBody = new MultipartBody.Builder()
                    .addFormDataPart("username", user)
                    .addFormDataPart("password", password)
                    .setType(MultipartBody.FORM)
                    .build();
            Request request = new Request.Builder()
                    .url("http://192.168.60.102:8080/apiqlsv/teacherlogin.php")
                    .post(requestBody)
                    .addHeader("Content-Type", "application/json")
                    .build();

            try {
                response = client.newCall(request).execute();
                return response.body().string();

                //  return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                ShowMessage(getBaseContext(),e.toString());
                // ShowMessage(getBaseContext(),"ko ket noi duoc" );
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {


            if (response.isSuccessful()) {
                try {
                    JSONObject json = new JSONObject(s);
                    String serverResponse = json.getString("message");


                 int serverError = json.getInt("error");

                    //get profile user
                    JSONObject ob_user = json.getJSONObject("data");
                    AccountStudent.studentName = ob_user.getString("studentName");
                    AccountStudent.idClass = ob_user.getInt("idClass");
                    AccountStudent.userName = ob_user.getString("userName");
                    AccountStudent.passWord = ob_user.getString("passWord");
                    AccountStudent.genDer = ob_user.getString("genDer");




                    if(serverError == 0) {
                        Intent intentStudent = new Intent(TeacherLoginActivity.this, StudentActivity.class);
                        startActivity(intentStudent);
                        finish();
                    }else{
                        if(serverError == 1){
                            Toast.makeText(TeacherLoginActivity.this,"Username or password is true",Toast.LENGTH_LONG);
                            return;
                        }if(serverError == 2){
                            Toast.makeText(TeacherLoginActivity.this,"Username or password is true",Toast.LENGTH_LONG);

                        }if(serverError == -2 || serverError == -1){
                            Toast.makeText(TeacherLoginActivity.this,"Login fail",Toast.LENGTH_LONG);

                        }
                    }



                } catch (Exception e) {
                    e.printStackTrace();

                }

            }

            super.onPostExecute(s);
        }
    }


}