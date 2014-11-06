package org.help;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by anshul on 4/11/14.
 */
public class Filter extends ActionBarActivity {
    private boolean isOpen = false;
    private boolean filterEvent=false;
    private boolean filterWish = false;
    private boolean[] filterCategory;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        // Initially the listview layout is invisible.
        final LinearLayout filterDropDownList = (LinearLayout) findViewById(R.id.filter_dropdown_list);
        filterDropDownList.setVisibility(View.INVISIBLE);

        //the category names are stored inside filter_category_names array
        String[] filterCategoryNames = getResources().getStringArray(R.array.filter_category_names);

        //Initialize a boolean array containing the boolean information of every category
        filterCategory = new boolean[filterCategoryNames.length];

        ListView filterCategoryListView = (ListView) findViewById(R.id.filter_dropdown_listview);
        ListAdapter adapter = new FilterCustomAdapter(this, filterCategoryNames);
        filterCategoryListView.setAdapter(adapter);
        filterCategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Log.d("position",position+"");
                if (filterCategory[position] == false) {
                    filterCategory[position] = true;
                } else {
                    filterCategory[position] = false;
                }
                Log.d("s",filterCategory[position]+"");
                CheckBox cb = (CheckBox)view.findViewById(R.id.filter_category_checkbox);
                cb.setChecked(!cb.isChecked());
            }
        });

        //DropDown to close and open the list
        ImageView filterDropDown = (ImageView) findViewById(R.id.filter_dropdown_button);
        filterDropDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //If the list is closed
                if (!isOpen) {
                    expand(filterDropDownList);
                    isOpen = true;
                } else {
                    //If the list is open.
                    collapse(filterDropDownList);
                    isOpen = false;
                }
            }
        });

        Button filterDone = (Button) findViewById(R.id.filter_done);
        filterDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2 = new Intent(Filter.this, MainActivity.class);
                startActivity(i2);
                Log.d("events",filterEvent+"");
                Log.d("wish",filterWish+"");
                for(int i =0;i<filterCategory.length;i++){
                    Log.d("status",filterCategory[i]+"");
                }
                overridePendingTransition(R.anim.hold, R.anim.up_to_down);

            }
        });


    }

    public static void expand(final View v) {
        v.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        v.getLayoutParams().height = 0;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LinearLayout.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public void onCheckBoxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.filter_event:
                if (checked) {
                    filterEvent=true;
                } else {
                    filterEvent=false;
                }
                // Remove the meat
                break;
            case R.id.filter_wish:
                if (checked) {
                    filterWish=true;
                } else {
                    filterWish=false;
                }
                // Cheese me
        }
    }
}
