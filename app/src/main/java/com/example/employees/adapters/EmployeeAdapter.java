package com.example.employees.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employees.R;
import com.example.employees.pojo.Employee;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private static final String TAG = "Debug EmployeeAdapter";

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item,
                parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.textViewName.setText(employee.getName());
        holder.textViewLastName.setText(employee.getLName());
        String uri = employee.getAvatarUrl();
        Log.d(TAG, "onBindViewHolder: " + employee.getAvatarUrl());
        if (uri != null && uri.length() > 0) {
            Picasso.get().load(employee.getAvatarUrl()).into(holder.imageViewAvatar);
        } else
            holder.imageViewAvatar.setImageResource(R.drawable.avatar);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewLastName;
        private ImageView imageViewAvatar;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textViewName);
            this.textViewLastName = itemView.findViewById(R.id.textViewLastName);
            this.imageViewAvatar = itemView.findViewById(R.id.imageViewSmallAvatar);
        }
    }
}
