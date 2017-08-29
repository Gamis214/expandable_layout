package com.example.gamis214.expandablelayout_example;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gamis214 on 29/08/17.
 */

public class adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> lsData;
    private int position;

    public adapter(ArrayList<String> lstData) {
        this.lsData = lstData;
    }

    public static class itemViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout expandButton;
        public ExpandableRelativeLayout expandableRelativeLayout;

        public itemViewHolder(View itemView) {
            super(itemView);

            this.expandButton = itemView.findViewById(R.id.container_expandable);
            this.expandableRelativeLayout = itemView.findViewById(R.id.expandableLayout);
            this.expandableRelativeLayout.collapse();

            expandButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expandableRelativeLayout.toggle();
                }
            });
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        itemViewHolder itemHolder = (itemViewHolder) holder;
        this.position = position;
    }

    @Override
    public int getItemCount() {
        return lsData.size();
    }

    public void remove(int position) {
        lsData.remove(position);
        notifyItemRemoved(position);
    }

    public void add(String text, int position) {
        lsData.add(position, text);
        notifyItemInserted(position);
    }

    public void addAll(List<String> data) {
        int oldSize = lsData.size();
        notifyItemRangeInserted(oldSize,data.size());
    }

    public void removeAll(int positionStar, int itemCount) {
        lsData.clear();
        notifyItemRangeRemoved(positionStar,itemCount);
    }
}