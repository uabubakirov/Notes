package com.example.notes.ui.home.AddNewNote;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notes.R;
import com.example.notes.databinding.FragmentAddNewNoteBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class AddNewNote extends Fragment {
    FragmentAddNewNoteBinding binding;
    Date currentDate = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd.MMMM", Locale.getDefault());
    String dateText = dateFormat.format(currentDate);
    DateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    String timeText = timeFormat.format(currentDate);



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddNewNoteBinding.inflate(inflater,container,false);

        binding.date.setText(dateText);
        binding.time.setText(timeText);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.txtReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.etDescription.getText().toString().trim();
                if (!text.isEmpty()){
                    Bundle bundle = new Bundle();
                    bundle.putString("text",text);
                    bundle.putString("date",dateText);
                    bundle.putString("time",timeText);
                    getParentFragmentManager().setFragmentResult("send",bundle);
                    NavController navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment_content_main);
                    navController.navigateUp();

                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar!=null){
            supportActionBar.hide();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar!=null){
            supportActionBar.show();
    }
}}