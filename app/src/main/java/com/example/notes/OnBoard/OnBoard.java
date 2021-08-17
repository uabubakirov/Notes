package com.example.notes.OnBoard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notes.MainActivity;
import com.example.notes.R;
import com.example.notes.databinding.ActivityOnBoardBinding;
import com.example.notes.utils.PrefHelper;

import java.util.ArrayList;
import java.util.List;

public class OnBoard extends AppCompatActivity {
    ActivityOnBoardBinding binding;
    FragmentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        List<ModelOnBoard> list = new ArrayList<>();
        list.add(new ModelOnBoard("Очень удобный функционал",R.drawable.first_img));
        list.add(new ModelOnBoard("Быстрый, качественный продукт",R.drawable.second_image));
        list.add(new ModelOnBoard("Куча функций и интересных фишек",R.drawable.third_image));
        adapter = new FragmentAdapter(getSupportFragmentManager(),list);
        binding.viewPager.setAdapter(adapter);
        binding.txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoard.this, MainActivity.class);
                startActivity(intent);
            }
        });
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        binding.select1.setImageResource(R.drawable.indicator_selected);
                        binding.select2.setImageResource(R.drawable.indicator_unselected);
                        binding.select3.setImageResource(R.drawable.indicator_unselected);
                        break;
                    case 1:
                        binding.select1.setImageResource(R.drawable.indicator_unselected);
                        binding.select2.setImageResource(R.drawable.indicator_selected);
                        binding.select3.setImageResource(R.drawable.indicator_unselected);

                        break;
                    case 2:
                        binding.select1.setImageResource(R.drawable.indicator_unselected);
                        binding.select2.setImageResource(R.drawable.indicator_unselected);
                        binding.select3.setImageResource(R.drawable.indicator_selected);
                        break;
                }
                if(binding.viewPager.getCurrentItem()==3){
                    binding.txtSkip.setText(null);
                }else{
                    binding.txtSkip.setText("Пропустить");
                }
                if(binding.viewPager.getCurrentItem()==3){
                    binding.begin.setText("Начать работу");
                    binding.begin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(OnBoard.this,MainActivity.class);
                            startActivity(intent);
                        }
                    });
                }else{
                    binding.begin.setText(null);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}