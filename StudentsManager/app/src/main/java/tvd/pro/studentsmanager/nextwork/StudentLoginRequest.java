package tvd.pro.studentsmanager.nextwork;


import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import tvd.pro.studentsmanager.model.modelstudent.AccountStudent;

public class StudentLoginRequest extends SeverRequest {
    public StudentLoginRequest(SeverRequestListener listener) {
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
                .url(URL + "studentlogin.php")
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();
        return request;
    }
    @Override
    protected Object process(String data) {
        try {
            final JSONObject json = new JSONObject(data);
            AccountStudent.error=(json.getInt("error"));

            if(AccountStudent.error==0){
                JSONObject user=json.getJSONObject("data");
                Gson gson=new Gson();
                AccountStudent st=gson.fromJson(String.valueOf(user),AccountStudent.class);
                AccountStudent.error=(json.getInt("error"));
                return st;
            }
            else{

                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
