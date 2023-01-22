package com.example.eyemedicationapp.ui.drops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eyemedicationapp.databinding.FragmentDropsBinding;

public class DropsFragment extends Fragment {

    private FragmentDropsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DropsViewModel dropsViewModel =
                new ViewModelProvider(this).get(DropsViewModel.class);

        binding = FragmentDropsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textMyDrops;
//        dropsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}