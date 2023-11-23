package com.ibookshop.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibookshop.fragments.Detail;
import com.ibookshop.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<Book> mBooks;
    private Context mContext;
    public BookAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<Book> list){
        this.mBooks=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.ibookshop.R.layout.item_sach,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book =mBooks.get(position);
        if (book == null){
            return;
        }
        holder.imgBook.setImageResource(book.getHinh());
        holder.txtTacGia.setText(book.getTenTacGia());
        holder.txtSach.setText(book.getTenSach());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocClickgotoDetail(book);
            }
        });
    }


    private void ocClickgotoDetail(Book book) {
        Intent intent = new Intent(mContext, Detail.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_category",book);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mBooks != null) {
            return mBooks.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgBook;
        private TextView txtSach;
        private TextView txtTacGia;

        private LinearLayout layoutItem;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBook = itemView.findViewById(R.id.imgSach);
            txtSach =  itemView.findViewById(R.id.TenSach);
            txtTacGia = itemView.findViewById(R.id.TenTacGia);
            layoutItem = itemView.findViewById(R.id.layoutItem);
        }
    }
}
