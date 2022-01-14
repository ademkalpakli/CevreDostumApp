package com.example.cevredostumapp;
//ademkalpakli
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cevredostumapp.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.cevredostumapp.databinding.FragmentEventBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyEventRecyclerViewAdapter extends RecyclerView.Adapter<MyEventRecyclerViewAdapter.ViewHolder> {

    private final List<Events> mValues;
    private EventFragment.OnEventSelected listener;
    int selectedIndex;

    public MyEventRecyclerViewAdapter(List<Events> items, EventFragment.OnEventSelected listener) {
        mValues = items;
        this.listener=listener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentEventBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(position+"");
        holder.mContentView.setText(mValues.get(position).getName());
        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (listener !=null ){
                  listener.eventSelected(holder.mItem);
                  notifyItemChanged(selectedIndex);
                  selectedIndex= holder.getLayoutPosition();
                  notifyItemChanged(selectedIndex);

              }
            }
        });
        holder.itemView.setBackgroundColor(selectedIndex == position ? Color.GRAY : Color.TRANSPARENT);


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Events mItem;

        public ViewHolder(FragmentEventBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}