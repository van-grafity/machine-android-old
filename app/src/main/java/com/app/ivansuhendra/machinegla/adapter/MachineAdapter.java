package com.app.ivansuhendra.machinegla.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.ivansuhendra.machinegla.R;
import com.app.ivansuhendra.machinegla.model.Machine;

import java.util.ArrayList;
public class MachineAdapter extends RecyclerView.Adapter<MachineAdapter.MachineViewHolder> {
    private static final String TAG = "MenuAdapter";
    private Context mContext;
    private ArrayList<Machine> machines;
    private itemAdapterOnClickHandler mItemClick;

    public interface itemAdapterOnClickHandler {
        void onClick(Machine machine, View view, int position);
    }

    public MachineAdapter(Context context, itemAdapterOnClickHandler itemClick) {
        this.mContext = context;
        this.mItemClick = itemClick;
    }

    @Override
    public MachineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_machine, parent, false);
        return new MachineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MachineViewHolder holder, int position) {
        Machine machine = machines.get(position);
        holder.tvName.setText(machine.getModel());
        holder.tvDesc.setText(machine.getSerialNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClick.onClick(machine, v, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return machines.size() == 0 ? 0 : machines.size();
    }

    public void setItems(ArrayList<Machine> products) {
        this.machines = products;
    }

    public void updateDataSet(ArrayList<Machine> products) {
        machines.clear();
        machines.addAll(products);
        notifyDataSetChanged();
    }

    class MachineViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvDesc;

        private MachineViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDesc = itemView.findViewById(R.id.tv_desc);
        }
    }
}