package org.help.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.help.NgoDonationFragment;
import org.help.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anshul on 2/11/14.
 */
public class DonationListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<String> categoryNames;

    public DonationListAdapter(Activity activity, List<String> categoryNames) {
        this.activity = activity;
        this.categoryNames = (ArrayList) categoryNames;
    }

    @Override
    public int getCount() {
        return categoryNames.size();
    }

    @Override
    public Object getItem(int location) {
        return categoryNames.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.donation_list_individual_row, null);
        convertView.setMinimumHeight(100);

        TextView donateListItem = (TextView) convertView.findViewById(R.id.donate_list_item);
        donateListItem.setText(categoryNames.get(position));

        ImageView deleteDonateListItem = (ImageView) convertView.findViewById(R.id.delete_donate_list_item);
        ImageView editDonateListItem  = (ImageView) convertView.findViewById(R.id.edit_donate_list_item);
        editDonateListItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                NgoDonationFragment.editListViewItem(position);
            }
        });

        deleteDonateListItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                categoryNames.remove(position);
                notifyDataSetChanged();

            }
        });
        return convertView;
    }

}
