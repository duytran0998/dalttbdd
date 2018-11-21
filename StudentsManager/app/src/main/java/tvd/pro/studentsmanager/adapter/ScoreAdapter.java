package tvd.pro.studentsmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tvd.pro.studentsmanager.R;
import tvd.pro.studentsmanager.model.modelstudent.Score;

public class ScoreAdapter extends BaseAdapter {
    Context context;
    int myLayout;
    ArrayList<Score> arrList;

    public ScoreAdapter(Context context, int myLayout, ArrayList<Score> arrList) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(myLayout,null);

        TextView txt_ViewScoreStudentID=convertView.findViewById(R.id.txt_ViewScoreStudentID);
        TextView txt_ViewScoreSubjectName=convertView.findViewById(R.id.txt_ViewScoreSubjectName);
        TextView txt_ViewScore=convertView.findViewById(R.id.txt_ViewScore);

        txt_ViewScoreStudentID.setText(String.valueOf(arrList.get(position).getIdStudent()));
        txt_ViewScoreSubjectName.setText(String.valueOf(arrList.get(position).getSubjectName()));
        txt_ViewScore.setText(String.valueOf(arrList.get(position).getScore()));

        return convertView;
    }
}
