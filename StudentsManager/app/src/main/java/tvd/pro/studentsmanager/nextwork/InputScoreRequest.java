package tvd.pro.studentsmanager.nextwork;


import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import tvd.pro.studentsmanager.model.Subject;
import tvd.pro.studentsmanager.model.TeacherClass;

public class InputScoreRequest extends SeverRequest {
    public InputScoreRequest(SeverRequestListener listener) {
        super(listener);
    }

    @Override
    protected Request prepare(Map<String, String> parameter) {

        String idStudent = parameter.get("idStudent");
        String idSubject =parameter.get("idSubject");
        String score =parameter.get("score");
        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("idStudent", idStudent)
                .addFormDataPart("idSubject",idSubject)
                .addFormDataPart("score",score)
                .setType(MultipartBody.FORM)
                .build();
        Request request = new Request.Builder()
                .url("http://"+URLserver.ipServer+":8080/apiqlsv/ChamDiem.php")
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();
        return request;
    }

    @Override
    protected Object process(String data) {

        try {
           JSONObject js=new JSONObject(data);

            int error=js.getInt("error");
            return  error;

            }

        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
