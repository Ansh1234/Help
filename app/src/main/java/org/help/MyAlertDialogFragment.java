package org.help;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class MyAlertDialogFragment extends DialogFragment {

    public static MyAlertDialogFragment newInstance(String title, String message) {
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        String message = getArguments().getString("message");
        LayoutInflater factory = LayoutInflater.from(getActivity());
        final View deleteDialogView = factory.inflate(
                R.layout.ngo_ratings, null);
       
        AlertDialog.Builder keyBuilder = new AlertDialog.Builder(getActivity(),android.R.style.Theme_Holo_Dialog_NoActionBar);
        keyBuilder
        .setCancelable(false)
        .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.v("Dialog","New Key: ");
            }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
               }
           });
        keyBuilder.setTitle("Decryption Failed");
        keyBuilder.setView(deleteDialogView);
        AlertDialog dialog = keyBuilder.create();
        //dialog.show();
         
         return dialog;
        
    }
}
