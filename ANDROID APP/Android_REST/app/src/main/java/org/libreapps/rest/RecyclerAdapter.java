package org.libreapps.rest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<DataCard> mDataCards;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView mDataName;
        public TextView mDataValue;

        public RecyclerViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mDataName = itemView.findViewById(R.id.dataNameText);
            mDataValue = itemView.findViewById(R.id.dataValueText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RecyclerAdapter(ArrayList<DataCard> dataCards) {
        mDataCards = dataCards;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_card, parent, false);
        RecyclerViewHolder rvh = new RecyclerViewHolder(v, mListener);
        return rvh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        DataCard currentCard = mDataCards.get(position);

        holder.mDataName.setText(currentCard.getDataName());
        holder.mDataValue.setText(currentCard.getDataValue());
    }

    @Override
    public int getItemCount() {
        return mDataCards.size();
    }
}
