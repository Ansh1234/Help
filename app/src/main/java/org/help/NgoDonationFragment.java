package org.help;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.help.adapters.DonationListAdapter;

import java.util.ArrayList;

/**
 * Created by anshul on 7/11/14.
 */
public class NgoDonationFragment extends Fragment {
    static ArrayList<String> donationItemList = new ArrayList<String>();
    static ArrayList<String> donationQuantityList = new ArrayList<String>();
    static ArrayList<String> donationDescriptionList = new ArrayList<String>();
    static EditText donationItem = null;
    static EditText donationQuantity = null;
    static EditText donationDescription = null;
    static Button donationItemAdd = null;
    static int position = 0;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ngo_donation, container, false);


        final ListView listView = (ListView) rootView.findViewById(R.id.donation_listview);
        donationItem = (EditText) rootView.findViewById(R.id.donation_item);
        donationQuantity = (EditText) rootView.findViewById(R.id.donation_quantity);
        donationDescription = (EditText) rootView.findViewById(R.id.donation_description);
        donationItemAdd = (Button) rootView.findViewById(R.id.donation_item_add);

        donationItemAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (donationItem.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getActivity(), "Name of the item is compulsary", Toast.LENGTH_LONG).show();
                    return;
                }
                else if(donationItemAdd.getText().toString().equalsIgnoreCase("modify")){
                    donationItemList.remove(position);
                    donationQuantityList.remove(position);
                    donationDescriptionList.remove(position);
                    donationItemList.add(position,donationItem.getText().toString());
                    donationQuantityList.add(position,donationQuantity.getText().toString());
                    donationDescriptionList.add(position,donationDescription.getText().toString());


                }
                else {
                donationItemList.add(donationItem.getText().toString());
                donationQuantityList.add(donationQuantity.getText().toString());
                donationDescriptionList.add(donationDescription.getText().toString());
                }
                ListAdapter adapter = new DonationListAdapter(getActivity(), donationItemList);
                listView.setAdapter(adapter);
                donationItem.setText("");
                donationQuantity.setText("");
                donationDescription.setText("");
                setListViewHeightBasedOnChildren(listView);
                listView.setFocusable(false);
                listView.setFocusableInTouchMode(false);
                listView.setClickable(false);
                listView.setItemsCanFocus(true);
            }
        });


        return rootView;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public static void editListViewItem(int position) {
        donationItemAdd.setText("Modify");
        donationItem.setText(donationItemList.get(position));
        donationQuantity.setText(donationQuantityList.get(position));
        donationDescription.setText(donationDescriptionList.get(position));
        NgoDonationFragment.position=position;


    }
}
