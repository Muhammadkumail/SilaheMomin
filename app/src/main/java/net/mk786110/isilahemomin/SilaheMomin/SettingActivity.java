package net.mk786110.isilahemomin.SilaheMomin;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.gms.ads.AdView;

import net.mk786110.isilahemomin.Datasource.DuaKumailDataSource;
import net.mk786110.isilahemomin.Model.Dua;
import net.mk786110.isilahemomin.R;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {

    DuaKumailDataSource mduaKumailDataSource;
    ArrayList<Dua> arrayList;
    ListView mlistViewDua;
    Context context;
    Boolean bCancelled;
    private AdView mAdView;
    Typeface urdufont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

      /*  multiColorPickerView.
        multiColorPickerView.addSelector(selectorDrawable, new ColorListener() {
            @Override
            public void onColorSelected(ColorEnvelope envelope) {
                int color = envelope.getColor();
                int[] rgb = envelope.getRgb();
                String htmlCode = envelope.getHtmlCode();

                // TODO
            }
        });*/
    }

}
