package com.example.oranmoshe.finalmobileproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleAdapterManager extends RecyclerView.Adapter<RecycleAdapterManager.ViewHolder> {
    private ArrayList<TaskItem> mDataset;
    private Context context;

    private final ArrayList<Integer> selected = new ArrayList<>();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public Button btn;
        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            btn= (Button) v.findViewById(R.id.button2);
        }
    }

    public void add(int position, TaskItem item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(TaskItem item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(int position) {
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecycleAdapterManager(ArrayList<TaskItem> myDataset ) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecycleAdapterManager.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        context = parent.getContext();
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final TaskItem task = mDataset.get(position);
        holder.txtHeader.setText(task.GetName());
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(task);
            }
        });
        holder.btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, TaskView.class);
                context.startActivity(intent);

              //  remove(holder.getAdapterPosition());

                if (!selected.contains(holder.getAdapterPosition())) {
                    selected.add(holder.getAdapterPosition());

                }else{
                    int index = selected.indexOf(holder.getAdapterPosition());
                    selected.remove(index);
                }
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

        // each time an item comes into view, its position is checked
        // against "selected" indices
        if (!selected.contains(position)){
            // view not selected
            holder.itemView.setBackgroundColor(Color.LTGRAY);
            holder.btn.setText("Done");
        }
        else{
            // view is selected
            holder.itemView.setBackgroundColor(Color.CYAN);
            holder.btn.setText("Undo");
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}