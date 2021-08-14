package com.example.notes.OnBoard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notes.R;
import com.example.notes.databinding.FragmentOnBoardBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OnBoardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnBoardFragment extends Fragment {
    FragmentOnBoardBinding binding;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    private String mText;
    private int mImage;

    public OnBoardFragment() {
        // Required empty public constructor
    }
    public static OnBoardFragment newInstance(String text, int image) {
        OnBoardFragment fragment = new OnBoardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, text);
        args.putInt(ARG_PARAM2, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString(ARG_PARAM1);
            mImage = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardBinding.inflate(inflater,container,false);
        binding.imgHello.setImageResource(mImage);
        binding.txtTitle.setText(mText);
        return binding.getRoot();
    }
}