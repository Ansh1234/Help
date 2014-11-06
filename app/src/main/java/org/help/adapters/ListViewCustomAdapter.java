package org.help.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import org.help.R;

/**
 * Created by anshul on 2/11/14.
 */
public class ListViewCustomAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private String[] categoryNames;

    public ListViewCustomAdapter(Activity activity, String[] categoryNames) {
        this.activity = activity;
        this.categoryNames = categoryNames;
    }

    @Override
    public int getCount() {
        return categoryNames.length;
    }

    @Override
    public Object getItem(int location) {
        return categoryNames[location];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.category_checkbox, null);
            convertView.setMinimumHeight(100);

        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.filter_category_checkbox);
        checkBox.setText(categoryNames[position]);


        return convertView;
    }

}
