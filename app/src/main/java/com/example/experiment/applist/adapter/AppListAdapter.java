package com.example.experiment.applist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.experiment.applist.App;
import com.example.experiment.databinding.ItemSelectAppBinding;

import java.util.ArrayList;
import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {

    private List<App> appList = new ArrayList<>();
    private final String TAG = AppListAdapter.class.getSimpleName();
    private OnSelectedCallBack onSelectedCallBack;
    private RadioButton lastCheckedRB;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemSelectAppBinding itemSelectAppBinding = ItemSelectAppBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemSelectAppBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(appList.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public void setAppList(List<App> appList) {
        this.appList = appList;
    }

    public void setOnSelectedCallBack(OnSelectedCallBack onSelectedCallBack) {
        this.onSelectedCallBack = onSelectedCallBack;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemSelectAppBinding binding;

        public ViewHolder(@NonNull final ItemSelectAppBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onSelectedCallBack != null) {
                        binding.rbSelectApp.setChecked(true);
                    }
                }
            });

            binding.rbSelectApp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        if (lastCheckedRB != null) {
                            lastCheckedRB.setChecked(false);
                        }
                        onSelectedCallBack.onSelectedCallBack(appList.get(getAdapterPosition()));
                        lastCheckedRB = binding.rbSelectApp;
                    }
                }
            });
        }

        public void bind(App app) {
            binding.setApp(app);
        }
    }

    public interface OnSelectedCallBack {
        void onSelectedCallBack(App app);
    }
}
