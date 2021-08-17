package com.example.notes.ui.home;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.notes.R;
import com.example.notes.databinding.ActivityMainBinding;
import com.example.notes.databinding.FragmentHomeBinding;
import com.example.notes.ui.home.AddNewNote.NoteAdapter;
import com.example.notes.ui.home.AddNewNote.NoteModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private NoteAdapter adapter;
    private Boolean isDashboard = false;
    LinearLayoutManager linearLayoutManager;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    private void getData() {
        getParentFragmentManager().setFragmentResultListener("send", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull @NotNull String requestKey, @NonNull @NotNull Bundle result) {
                String text = result.getString("text");
                String date = result.getString("date");
                String time = result.getString("time");
                NoteModel model = new NoteModel(text,date,time);
                adapter.addText(model);
                if(isDashboard){
                    binding.rvRecycler.setLayoutManager(staggeredGridLayoutManager);
                }else{
                    binding.rvRecycler.setLayoutManager(linearLayoutManager);
                }
            }
        });
    }

    private void initView() {
        binding.rvRecycler.setLayoutManager(linearLayoutManager);
        binding.rvRecycler.setAdapter(adapter);


    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        adapter = new NoteAdapter();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        linearLayoutManager = new LinearLayoutManager(requireContext());
        initView();
        getData();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        inflater.inflate(R.menu.main,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {
        if (item.getItemId() == R.id.dashboard){
            isDashboard = !isDashboard;
            if(isDashboard){
                item.setIcon(R.drawable.ic_format_list);
            }else{
                item.setIcon(R.drawable.ic_dashboard);
            }
            binding.rvRecycler.setLayoutManager(isDashboard ? staggeredGridLayoutManager : linearLayoutManager);
            binding.rvRecycler.setAdapter(adapter);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}