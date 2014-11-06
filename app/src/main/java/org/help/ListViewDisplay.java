package org.help;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListViewDisplay extends Fragment implements ViewDisplay {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View listviewdisplay = inflater.inflate(R.layout.listviewdisplay, container, false);
        ListView listView = (ListView) listviewdisplay.findViewById(R.id.main_activity_listview);
        String[] ngoNames = {"Enable India", "Goonj", "Jnana Mandira", "Make A Wish"};
        ListAdapter adapter = new NgoListCustomAdapter(getActivity(), ngoNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity(), NgoDisplay.class);
                startActivity(intent);
            }
        });
        return listviewdisplay;

    }

}
