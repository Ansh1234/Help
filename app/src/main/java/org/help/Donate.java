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
import org.help.adapters.RecentRequirementsCustomAdapter;
import org.help.utilities.ListViewUtilities;

/**
 * Created by anshul on 7/11/14.
 */
public class Donate extends ActionBarActivity {
    private boolean isOpen = false;
    private boolean filterEvent = false;
    private boolean filterWish = false;
    private boolean[] donateCategory;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);

        // Initially the listview layout is invisible.
        final LinearLayout donateDropDownList = (LinearLayout) findViewById(R.id.donate_dropdown_list);
        donateDropDownList.setVisibility(View.INVISIBLE);

        //the filter category names of NGOs are stored inside filter_category_names array
        String[] donateCategoryNames = getResources().getStringArray(R.array.donate_category_names);

        //Initialize a boolean array containing the boolean information of every category
        donateCategory = new boolean[donateCategoryNames.length];


        ListView filterCategoryListView = (ListView) findViewById(R.id.donate_dropdown_listview);
        ListAdapter adapter = new ListViewCustomAdapter(this, donateCategoryNames);
        filterCategoryListView.setAdapter(adapter);
        filterCategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Log.d("position", position + "");
                if (donateCategory[position] == false) {
                    donateCategory[position] = true;
                } else {
                    donateCategory[position] = false;
                }
                Log.d("s", donateCategory[position] + "");
                CheckBox cb = (CheckBox) view.findViewById(R.id.filter_category_checkbox);
                cb.setChecked(!cb.isChecked());
            }
        });

        //DropDown to close and open the list
        ImageView donateDropDown = (ImageView) findViewById(R.id.donate_dropdown_button);
        donateDropDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //If the list is closed
                if (!isOpen) {
                    ListViewUtilities.expand(donateDropDownList);
                    isOpen = true;
                } else {
                    //If the list is open.
                    ListViewUtilities.collapse(donateDropDownList);
                    isOpen = false;
                }
            }
        });

        /*
            This listview is for displaying the recent requirements of the NGOs
            If the user selects a requirement from this list
            then he will be redirected to the DonateForm Screen
         */
        ListView recentRequirementsListView = (ListView)findViewById(R.id.donate_requirements_listview);
        ListAdapter listAdapter = new RecentRequirementsCustomAdapter(this,donateCategoryNames);
        recentRequirementsListView.setAdapter(listAdapter);


        /*
            The user select some categories to donate
            After clicking the button, the user is redirected to the MainActivity Screen
            Only those NGOs are displayed which accepts the above applied categories
        */
        Button donateNext = (Button) findViewById(R.id.donate_next);
        donateNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2 = new Intent(Donate.this, MainActivity.class);
                startActivity(i2);
                overridePendingTransition(R.anim.hold, R.anim.up_to_down);

            }
        });

    }
}
