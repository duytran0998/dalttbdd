package tvd.pro.studentsmanager.nextwork;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import tvd.pro.studentsmanager.model.modelteacher.TeacherClass;

public class GetClassReQuest extends SeverRequest {
    public GetClassReQuest(SeverRequestListener listener) {
        super(listener);
    }

    @Override
    protected Request prepare(Map<String, String> parameter) {

        String idSubject = parameter.get("idSubject");
        String idTeacher =parameter.get("idTeacher");

        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("idSubject", idSubject)
                .addFormDataPart("idTeacher",idTeacher)
                .setType(MultipartBody.FORM)
                .build();
        Request request = new Request.Builder()
                .url("http://"+URLserver.ipServer+":8080/apiqlsv/teachergetclass.php")
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();
        return request;
    }

    @Override
    protected Object process(String data) {

        try {
            ArrayList<TeacherClass> arr=new ArrayList<TeacherClass>();
            JSONArray json= new JSONArray(data);
            for(int i=0;i<json.length();i++){
                JSONObject ob=json.getJSONObject(i);


                arr.add(new TeacherClass(
                        ob.getInt("idClass"),
                        ob.getInt("idTeacher"),
                        ob.getInt("idSubject"),
                        ob.getString("className"),
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
