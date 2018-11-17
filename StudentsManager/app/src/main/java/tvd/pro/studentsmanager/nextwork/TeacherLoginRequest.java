package tvd.pro.studentsmanager.nextwork;


import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import tvd.pro.studentsmanager.model.AccountTeacher;

public class TeacherLoginRequest extends SeverRequest {
    public TeacherLoginRequest(SeverRequestListener listener) {
        super(listener);
    }

    @Override
    protected Request prepare(Map<String, String> parameter) {

        String user = parameter.get("username");
        String pass = parameter.get("password");




        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("username", user)
                .addFormDataPart("password",pass)
                .setType(MultipartBody.FORM)
                .build();
        Request request = new Request.Builder()
                .url(URL + "teacherlogin.php")
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();
        return request;

    }

    @Override
    protected Object process(String data) {
        try {
            final JSONObject json = new JSONObject(data);

            JSONObject user=json.getJSONObject("data");
            Gson gson=new Gson();
            AccountTeacher tc=gson.fromJson(String.valueOf(user),AccountTeacher.class);
            tc.setError(json.getInt("error"));
            return tc;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
