package net.mk786110.silahemomin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import net.mk786110.silahemomin.Adaptor.AlbumsAdapter;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.AllMolanasDataSource;
import net.mk786110.silahemomin.Model.Album;
import net.mk786110.silahemomin.SilaheMomin.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class MajlisActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    AllMolanasDataSource mAllMolanasDataSource;
    ArrayList<Album> arrayListmolanas;
    Context context;
    Boolean bCancelled;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majlis);
        context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new get_Videos_AsynchTask().execute();
        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();


        try {
            Glide.with(this).load(R.drawable.ic_majlis).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name_urdu));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    DialogInterface.OnCancelListener cancelListener = new DialogInterface.OnCancelListener() {
        @Override
        public void onCancel(DialogInterface arg0) {
            bCancelled = true;
            finish();
        }
    };
    private class get_Videos_AsynchTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog progressDialog;
        String connectionError = "";

        @Override
        protected void onPreExecute() {

            progressDialog = ProgressDialog.show(context, "wait", C.Salwat, true);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled = false;


            arrayListmolanas = new ArrayList<>();

            mAllMolanasDataSource = new AllMolanasDataSource(context);

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {


            arrayListmolanas = mAllMolanasDataSource.getList();
            if (arrayListmolanas.size() == 0) {
                connectionError = "Please Check Internet Connection";

                return null;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (connectionError.length() != 0) {
                C.helperMethods.showMessage(connectionError, context);
                progressDialog.dismiss();
            } else {
                super.onPostExecute(aVoid);
                adapter = new AlbumsAdapter(context, arrayListmolanas);

                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 2);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();
            }

        }
    }
}

