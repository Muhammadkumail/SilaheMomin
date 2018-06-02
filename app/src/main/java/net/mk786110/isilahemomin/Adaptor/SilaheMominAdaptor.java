package net.mk786110.isilahemomin.Adaptor;

        import android.content.Context;
        import android.graphics.Typeface;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import net.mk786110.isilahemomin.Constant.SingletonClass;
        import net.mk786110.isilahemomin.Model.Dua;
        import net.mk786110.isilahemomin.R;

        import java.util.ArrayList;

public class SilaheMominAdaptor extends ArrayAdapter<Dua> {

    Context context;
    Typeface urdufont,arabicfont;

    public SilaheMominAdaptor(Context _context, int resource, ArrayList<Dua> objects) {

        super(_context, resource, objects);
        this.context = _context;

         urdufont = SingletonClass.getLanguageFontInstance(context, "urdu");
         arabicfont = SingletonClass.getLanguageFontInstance(context, "arabic");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Dua item = getItem(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_row, parent, false);
        TextView duaArabicPart = (TextView) rowView.findViewById(R.id.row_arabic_textview);
        TextView duaurduPart = (TextView) rowView.findViewById(R.id.row_urdu_textview);

        /*SET DATA*/
        duaArabicPart.setText(item.getDua_arabic_part());
        duaurduPart.setText(item.getDua_urdu_part());

        /*SET FONT TYPE*/
        duaurduPart.setTypeface(urdufont);
        //duaArabicPart.setTypeface(arabicfont);

        /*SET FONT SIZE*/
        duaurduPart.setTextSize(30);

        return rowView;
    }

}