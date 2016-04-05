package net.mk786110.silahemomin.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class DuaAbuHamza1Adaptor extends ArrayAdapter<Dua> {

    Context context;

    public DuaAbuHamza1Adaptor(Context _context, int resource, ArrayList<Dua> objects) {

        super(_context, resource, objects);
        this.context=_context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Dua item =getItem(position);

        LayoutInflater inflater = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_row, parent, false);

        TextView duaArabicPart=(TextView) rowView.findViewById(R.id.row_arabic_textview);
        TextView duaurduPart=(TextView) rowView.findViewById(R.id.row_urdu_textview);

        duaArabicPart.setText(item.getDua_arabic_part());
        duaurduPart.setText(item.getDua_urdu_part());

        return  rowView;
    }


}
