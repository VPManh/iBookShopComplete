package com.ibookshop.fragments;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibookshop.R;
import com.ibookshop.data.Book;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//


        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Book book = (Book) bundle.get("object_category");
        RelativeLayout relativeLayout = findViewById(R.id.detail_1); // Thay thế bằng ID của RelativeLayout của bạn

        int childCount = relativeLayout.getChildCount();
        TextView tensach = findViewById(R.id.tv_name_category);
        ImageView hinh = findViewById(R.id.hinh);
        TextView tentg = findViewById(R.id.tacgia);
        for (int i = 0; i < childCount; i++) {
            View childView = relativeLayout.getChildAt(i);
            tensach.setText(book.getTenSach());
            hinh.setImageResource(book.getHinh());
            tentg.setText(book.getTenTacGia());
        }

    }



}