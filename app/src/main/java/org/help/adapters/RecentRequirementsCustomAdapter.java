package org.help.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.help.R;

/**
 * Created by anshul on 7/11/14.
 */
public class RecentRequirementsCustomAdapter extends BaseAdapter {
        private Activity activity;
        private LayoutInflater inflater;
        private String[] categoryNames;

        public RecentRequirementsCustomAdapter(Activity activity, String[] categoryNames) {
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
                convertView = inflater.inflate(R.layout.main_activity_list_view_individual_row, null);

            TextView listViewNgoName = (TextView) convertView.findViewById(R.id.list_view_ngo_name);
            listViewNgoName.setTypeface(Typeface.createFromAsset(activity.getAssets(), "Quicksand-Bold.otf"));
            listViewNgoName.setText(categoryNames[position]);


            return convertView;
        }

    }

