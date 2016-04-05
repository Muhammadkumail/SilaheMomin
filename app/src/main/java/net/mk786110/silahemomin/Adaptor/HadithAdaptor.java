package net.mk786110.silahemomin.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.Model.Hadith;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class HadithAdaptor extends ArrayAdapter<Hadith> {

    Context context;

    public HadithAdaptor(Context _context, int resource, ArrayList<Hadith> objects) {

        super(_context, resource, objects);
        this.context=_context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Hadith item =getItem(position);

        LayoutInflater inflater = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_hadith_row, parent, false);

        TextView hadith=(TextView) rowView.findViewById(R.id.row_hadith_textview);
        TextView author=(TextView) rowView.findViewById(R.id.row_author_textview);

        hadith.setText(item.getHadith());
        author.setText(item.getHadith_author());

        return  rowView;
    }


}
