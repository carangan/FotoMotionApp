package com.example.fotomotionapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

public class AddPanelDialogue extends AppCompatDialogFragment {

    private EditText editTextProjectName;
    private EditText editTextUsername;

    private ExampleDialogListener listener;

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setIcon(R.mipmap.sailormoon);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_panel, null);


        builder.setView(view)
                .setTitle("Yo mama")
                .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String projectName = editTextProjectName.getText().toString();
                        String username = editTextUsername.getText().toString();

                        listener.applyTexts(projectName, username);
                    }
                });

        editTextProjectName = view.findViewById(R.id.popupProjectName);
        editTextUsername = view.findViewById(R.id.popupUsername);

        return builder.create();
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String projectName, String username);
    }
}
