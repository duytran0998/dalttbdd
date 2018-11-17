package tvd.pro.studentsmanager.activities;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import tvd.pro.studentsmanager.R;
import tvd.pro.studentsmanager.nextwork.URLserver;

public class ChangePassTeacher extends AppCompatActivity {
    EditText oldPassWord, newPassWord, renewPassWord;
    String getIdTeacher, getPassWord;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass_student);
        oldPassWord = findViewById(R.id.oldPassword);
        newPassWord = findViewById(R.id.newPassWord);
        renewPassWord = findViewById(R.id.renewPassWord);
        btnUpdate = findViewById(R.id.btnUpdate);


        getIdTeacher = getIntent().getStringExtra("sendIdTeacher");
        getPassWord = getIntent().getStringExtra("sendPassWord");


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String oldPass = oldPassWord.getText().toString();
                final String newPass = newPassWord.getText().toString();
                final String renewPass = renewPassWord.getText().toString();


                if (oldPass.equals(getPassWord)) {
                    if ((newPass.equals(renewPass))) {
                        new ChangeInfoOnServer(oldPass, newPass).execute();
                        ShowMessage(getBaseContext(), "Đổi mật khẩu thành công!");
                    } else {
                        if (!newPass.equals(renewPass)) {
                            ShowMessage(getBaseContext(), "Nhập lại mật khẩu mới không hợp lệ!");

                        }
                    }


                } else {
                    ShowMessage(getBaseContext(), "Mật khẩu cũ không đúng!");
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

    public class ChangeInfoOnServer extends AsyncTask<String, Void, String> {
        Response response;
        OkHttpClient client = new OkHttpClient.Builder().build();
        String oldPass, newPass, renewPass;

        public ChangeInfoOnServer(String oldPass, String newPass) {
            this.oldPass = oldPass;
            this.newPass = newPass;
        }

        @Override
        protected String doInBackground(String... strings) {
            RequestBody requestBody = new MultipartBody.Builder()
                    .addFormDataPart("oldPW", oldPass)
                    .addFormDataPart("newPW", newPass)
                    .addFormDataPart("idTeacher", getIdTeacher)
                    .setType(MultipartBody.FORM)
                    .build();
            Request request = new Request.Builder()
                    .url("http://"+ URLserver.ipServer+":8080/apiqlsv/changepasswordst.php")
                    .post(requestBody)
                    .addHeader("Content-Type", "application/json")
                    .build();


            try {
                response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                ShowMessage(getBaseContext(), e.toString());

            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if (response.isSuccessful()) {

            }
            super.onPostExecute(s);
        }
    }

}
