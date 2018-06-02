package net.mk786110.isilahemomin.Adaptor;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.mk786110.isilahemomin.Constant.SingletonClass;
import net.mk786110.isilahemomin.Model.Majlis;
import net.mk786110.isilahemomin.R;

import java.util.ArrayList;

public class MajlisAdaptor extends ArrayAdapter<Majlis> {

    Context context;
    Typeface urdufont,arabicfont;

    public MajlisAdaptor(Context _context, int resource, ArrayList<Majlis> objects) {

        super(_context, resource, objects);
        this.context = _context;

         urdufont = SingletonClass.getLanguageFontInstance(context, "urdu");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Majlis item = getItem(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_row_majlis, parent, false);
        TextView topicName = (TextView) rowView.findViewById(R.id.row_majlis_textview);

        /*SET DATA*/
        topicName.setText(item.getMajlis_topic());

        /*SET FONT TYPE*/
        topicName.setTypeface(urdufont);

        /*SET FONT SIZE*/
        topicName.setTextSize(20);

        return rowView;
    }

}
