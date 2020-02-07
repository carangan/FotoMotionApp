package com.example.fotomotionapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ProjectOptionsFragment extends BottomSheetDialogFragment {

    private OptionListener listener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View projectView = inflater.inflate(R.layout.project_details_bottom_sheet, container, false);

        return projectView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (OptionListener) context;
        } catch (ClassCastException exception) {
            exception.printStackTrace(); // won't necessarily work, use Log.d()
        }
    }

    public interface OptionListener {
        void onClick();
    }
}
