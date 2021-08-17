package com.example.notes.ui.home.AddNewNote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.databinding.FragmentAddNewNoteBinding;
import com.example.notes.databinding.RecyclerItemsBinding;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    ArrayList<NoteModel> list = new ArrayList<>();
    RecyclerItemsBinding binding;
    Date currentDate = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
    String dateText = dateFormat.format(currentDate);
    DateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    String timeText = timeFormat.format(currentDate);



    public void addText(NoteModel model) {
        list.add(model);
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        binding = RecyclerItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
        public void onBind (NoteModel model){
            binding.rvText.setText(model.getText());
            binding.date.setText(model.getDate());
            binding.time.setText(model.getTime());
        }


    }}