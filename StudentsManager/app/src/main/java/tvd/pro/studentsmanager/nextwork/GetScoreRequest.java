package tvd.pro.studentsmanager.nextwork;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import tvd.pro.studentsmanager.model.Score;
import tvd.pro.studentsmanager.model.ScoreStudent;
import tvd.pro.studentsmanager.model.Subject;

public class GetScoreRequest extends SeverRequest {
    public GetScoreRequest(SeverRequestListener listener) {
        super(listener);
    }

    @Override
    protected Request prepare(Map<String, String> parameter) {

        String idStudent = parameter.get("idStudent");


        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("idStudent", idStudent)
                .setType(MultipartBody.FORM)
                .build();
        Request request = new Request.Builder()
                .url("http://"+URLserver.ipServer+":8080/apiqlsv/getscore.php")
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();
        return request;
    }

    @Override
    protected Object process(String data) {

        try {
            ArrayList<Score> arr=new ArrayList<Score>();
            JSONArray json= new JSONArray(data);
            for(int i=0;i<json.length();i++){
                JSONObject ob=json.getJSONObject(i);

                arr.add(new Score(
                        ob.getInt("idStudent"),
                        ob.getString("subjectName"),
                        (float) ob.getDouble("Score")

                ));

            }
            return  arr;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
