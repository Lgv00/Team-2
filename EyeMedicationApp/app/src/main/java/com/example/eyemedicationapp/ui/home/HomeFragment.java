package com.example.eyemedicationapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import com.example.eyemedicationapp.AppDatabase;
import com.example.eyemedicationapp.Event;
import com.example.eyemedicationapp.EventListItemAdapter;
import com.example.eyemedicationapp.Prescription;
import com.example.eyemedicationapp.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;

    }

    @Override
    public void onResume() {
        super.onResume();

        AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, "droppy4").allowMainThreadQueries().build();
        List<Prescription> ps = db.prescriptionDAO().getAll();
        List<Event> es = db.eventDAO().getAll();
        EventListItemAdapter adapter = new EventListItemAdapter(getContext(),db.eventPrescriptionDao().loadEventsAndPrescriptions());
        binding.eventListView.setAdapter(adapter);
        db.close();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}