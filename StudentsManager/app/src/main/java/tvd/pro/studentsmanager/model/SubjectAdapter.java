package tvd.pro.studentsmanager.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tvd.pro.studentsmanager.R;

public class SubjectAdapter extends BaseAdapter {
    Context context;
    int myLayout;
    ArrayList<Subject> arrList;

    public SubjectAdapter(Context context, int myLayout, ArrayList<Subject> arrList) {
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

        TextView txt_subjectname=convertView.findViewById(R.id.txt_subjectname);
        TextView txt_subjectid=convertView.findViewById(R.id.txt_subjectID);
        ImageView img_hinh=convertView.findViewById(R.id.imageView);
        txt_subjectname.setText(arrList.get(position).getSubjectName());
        txt_subjectid.setText(String.valueOf(arrList.get(position).getIdSubject()));
        img_hinh.setImageResource(R.drawable.ic_lens_black_24dp);

        return convertView;
    }
}
