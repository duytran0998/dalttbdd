package tvd.pro.studentsmanager.nextwork;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import tvd.pro.studentsmanager.model.Subject;

public class GetSubjectRequest extends SeverRequest {
    public GetSubjectRequest(SeverRequestListener listener) {
        super(listener);
    }

    @Override
    protected Request prepare(Map<String, String> parameter) {

        String idTeacher = parameter.get("idTeacher");

        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("idTeacher", idTeacher)
                .setType(MultipartBody.FORM)
                .build();
        Request request = new Request.Builder()
                .url("http://"+URLserver.ipServer+":8080/apiqlsv/getteachersubject.php")
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();
        return request;
    }

    @Override
    protected Object process(String data) {

        try {
            ArrayList<Subject> arr=new ArrayList<Subject>();
            JSONArray json= new JSONArray(data);
            for(int i=0;i<json.length();i++){
                JSONObject ob=json.getJSONObject(i);

                arr.add(new Subject(
                        ob.getInt("idTeacher"),
                        ob.getInt("idSubject"),
                        ob.getString("subjectName"),
                        ob.getString("note")
                ));

            }
            return  arr;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
