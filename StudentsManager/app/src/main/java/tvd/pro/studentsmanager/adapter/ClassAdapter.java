package tvd.pro.studentsmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tvd.pro.studentsmanager.R;
import tvd.pro.studentsmanager.model.modelteacher.TeacherClass;

public class ClassAdapter extends BaseAdapter {
    Context context;
    int myLayout;
    ArrayList<TeacherClass> arrList;

    public ClassAdapter(Context context, int myLayout, ArrayList<TeacherClass> arrList) {
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

        TextView txt_className=convertView.findViewById(R.id.txt_classname);
        TextView txt_classID=convertView.findViewById(R.id.txt_classID);
        ImageView img_hinh=convertView.findViewById(R.id.imageView);
        txt_className.setText(arrList.get(position).getClassName());
        txt_classID.setText(String.valueOf(arrList.get(position).getIdClass()));
        img_hinh.setImageResource(R.drawable.ic_home_black_24dp);

        return convertView;
    }
}
