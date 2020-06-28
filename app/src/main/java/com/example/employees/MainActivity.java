package com.example.employees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.employees.adapters.EmployeeAdapter;
import com.example.employees.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewEmployees;
    private EmployeeAdapter adapter;
    private EmployeeViewModel viewModel;
    private Disposable disposable;
    public static String TAG = "dbg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        viewModel.getEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                adapter.setEmployees(employees);
            }
        });
        viewModel.getErrors().observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                if (throwable != null) {
                    Toast.makeText(MainActivity.this, "Error\n" + throwable, Toast.LENGTH_LONG).show();
                    Log.d(TAG, throwable.toString());
                    viewModel.clearErrors();
                }
            }
        });
        viewModel.loadData();
    }

    private void init() {
        recyclerViewEmployees = findViewById(R.id.recyclerViewEmployees);
        adapter = new EmployeeAdapter();
        adapter.setEmployees(new ArrayList<Employee>());
        recyclerViewEmployees.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEmployees.setAdapter(adapter);
        viewModel = new ViewModelProvider(this,
                new EmployeeViewModelFactory(getApplication())).get(EmployeeViewModel.class);
    }
    @Override
    protected void onDestroy() {
        if (disposable != null)
            disposable.dispose();
        super.onDestroy();
    }

    public void onClickAddEmployee(View view) {
        Intent intent = new Intent(this, AddEmployeeActivity.class);
        startActivity(intent);
    }
}
