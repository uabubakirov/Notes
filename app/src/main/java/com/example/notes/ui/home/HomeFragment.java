package com.example.notes.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notes.R;
import com.example.notes.databinding.FragmentHomeBinding;
import com.example.notes.ui.home.AddNewNote.NoteAdapter;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private NoteAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        adapter = new NoteAdapter();
        getData();
        return root;
    }

    private void getData() {
        getParentFragmentManager().setFragmentResultListener("send", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull @NotNull String requestKey, @NonNull @NotNull Bundle result) {
                String text = result.getString("text");
                adapter.addText(text);
            }
        });
    }

    private void initView() {
        binding.rvRecycler.setAdapter(adapter);

    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}