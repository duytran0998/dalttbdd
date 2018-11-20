package tvd.pro.studentsmanager.nextwork;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import tvd.pro.studentsmanager.model.ScoreStudent;
import tvd.pro.studentsmanager.model.Subject;

public class ScoreStudentRequest extends SeverRequest {
    public ScoreStudentRequest(SeverRequestListener listener) {
        super(listener);
    }

    @Override
    protected Request prepare(Map<String, String> parameter) {

        String idClass = parameter.get("idClass");
        String idSubject = parameter.get("idSubject");

        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("idClass", idClass)
                .addFormDataPart("idSubject", idSubject)
                .setType(MultipartBody.FORM)
                .build();
        Request request = new Request.Builder()
                .url("http://"+URLserver.ipServer+":8080/apiqlsv/score.php")
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();
        return request;
    }

    @Override
    protected Object process(String data) {

        try {
            ArrayList<ScoreStudent> arr=new ArrayList<ScoreStudent>();
            JSONArray json= new JSONArray(data);
            for(int i=0;i<json.length();i++){
                JSONObject ob=json.getJSONObject(i);

                arr.add(new ScoreStudent(
                        ob.getInt("idStudent"),
                        ob.getString("nameStudent"),
                        (float) ob.getDouble("score")

                ));

            }
            return  arr;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
