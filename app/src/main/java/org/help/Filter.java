package org.help;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.help.adapters.ListViewCustomAdapter;
import org.help.utilities.ListViewUtilities;

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

        //the filter category names of NGOs are stored inside filter_category_names array
        String[] filterCategoryNames = getResources().getStringArray(R.array.filter_category_names);

        //Initialize a boolean array containing the boolean information of every category
        filterCategory = new boolean[filterCategoryNames.length];

        ListView filterCategoryListView = (ListView) findViewById(R.id.filter_dropdown_listview);
        ListAdapter adapter = new ListViewCustomAdapter(this, filterCategoryNames);
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
                    ListViewUtilities.expand(filterDropDownList);
                    isOpen = true;
                } else {
                    //If the list is open.
                    ListViewUtilities.collapse(filterDropDownList);
                    isOpen = false;
                }
            }
        });

        Button filterDone = (Button) findViewById(R.id.filter_done);
        filterDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2 = new Intent(Filter.this, MainActivity.class);
                startActivity(i2);
                Log.d("events", filterEvent + "");
                Log.d("wish",filterWish+"");
                for(int i =0;i<filterCategory.length;i++){
                    Log.d("status",filterCategory[i]+"");
                }
                overridePendingTransition(R.anim.hold, R.anim.up_to_down);

            }
        });


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
