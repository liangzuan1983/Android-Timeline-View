package com.akshaykale.swipetimeline;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by akshaykale on 2017/08/18.
 */

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalRecyclerViewHolder> {


    ArrayList<String> list;
    Context context;

    public VerticalRecyclerViewAdapter(Context context, ArrayList<String> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public VerticalRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_timeline_layout, parent, false);

        return new VerticalRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VerticalRecyclerViewHolder holder, int position) {
        holder.time.setText(TimeLineConfig.headerList.get(position));
        //holder.header.setText(TimeLineConfig.headerList.get());


        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter = new HorizontalRecyclerViewAdapter(TimeLineConfig.timelineObjMap.get(TimeLineConfig.headerList.get(position)));
        holder.recyclerView.setAdapter(horizontalRecyclerViewAdapter);

    }

    @Override
    public int getItemCount() {
        return TimeLineConfig.headerList.size();
    }


    public class VerticalRecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView time, header;
        public RecyclerView recyclerView;

        public VerticalRecyclerViewHolder(View view) {
            super(view);

            time = (TextView) view.findViewById(R.id.tv_timeline_time);
            header = (TextView) view.findViewById(R.id.tv_timeline_header);

            recyclerView = (RecyclerView) view.findViewById(R.id.rv_horizontal_timeline);

            LinearLayoutManager recyclerViewLayoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(recyclerViewLayoutManager);
            LinearLayoutManager horizontalLinearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(horizontalLinearLayoutManager);

        }
    }
}
