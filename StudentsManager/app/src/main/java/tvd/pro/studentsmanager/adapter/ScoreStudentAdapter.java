package tvd.pro.studentsmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tvd.pro.studentsmanager.R;
import tvd.pro.studentsmanager.activities.teacher.InputScoreStudentActivity;
import tvd.pro.studentsmanager.model.Select;
import tvd.pro.studentsmanager.model.modelstudent.ScoreStudent;

public class ScoreStudentAdapter extends BaseAdapter {
    Context context;
    int myLayout;
    ArrayList<ScoreStudent> arrList;
    public  static String STUDENTID="masv";
    public  static  String STUDENTNAME="tenhocsinh";
    public  static  String SUBJECTID="mamonhoc";

    public ScoreStudentAdapter(Context context, int myLayout, ArrayList<ScoreStudent> arrList) {
        this.context = context;
        this.myLayout = myLayout;
        this.arrList = arrList;
    }

    @Override
    public int getCount() {
        return arrList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(myLayout,null);

        TextView ttx_name=convertView.findViewById(R.id.txt_StudentName);
        TextView txt_id=convertView.findViewById(R.id.txt_studentID);
        TextView txt_score=convertView.findViewById(R.id.txt_score);
        ImageView img_edit=convertView.findViewById(R.id.img_edt);

        txt_id.setText(String.valueOf(arrList.get(position).getIdStudent()));
        ttx_name.setText(arrList.get(position).getNameStudent());
        txt_score.setText(String.valueOf(arrList.get(position).getScore()));
        img_edit.setImageResource(R.drawable.ic_edit_black_24dp);



        // EVEBT DELETE AND EVENT UPDATE
        img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i=new Intent(context,UpdateSinhVinActivity.class);
                // context.startActivity(i);
                Intent intent=new Intent(context,InputScoreStudentActivity.class);



                intent.putExtra(STUDENTID, String.valueOf(arrList.get(position).getIdStudent()));
                intent.putExtra(STUDENTNAME, arrList.get(position).getNameStudent());
                intent.putExtra(SUBJECTID, String.valueOf(Select.MAMONHOC));
                context.startActivity(intent);

            }
        });

        return convertView;
    }
}
