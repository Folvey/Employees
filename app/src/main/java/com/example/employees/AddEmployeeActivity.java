package com.example.employees;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.employees.api.ApiFactory;
import com.example.employees.api.ApiService;
import com.example.employees.data.AppDatabase;
import com.example.employees.pojo.Employee;

import java.util.List;

public class AddEmployeeActivity extends AppCompatActivity {

    private static AppDatabase appDatabase;

    EditText editTextName;
    EditText editTextLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        init();
    }

    private void init() {
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);

    }
    public void onClickAddEmployee(View view) {
        String name = editTextName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        Employee employee = new Employee(name, lastName, "1", "1");

        appDatabase = AppDatabase.getInstance(this);
        Log.d("dbg", "before task");
        new InsertEmployeeTask().execute(employee);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private static class InsertEmployeeTask extends AsyncTask<Employee, Void, Void> {
        @Override
        protected Void doInBackground(Employee... employees) {
            Log.d("dbg", "task started");
            if (employees != null) {
                appDatabase.employeeDao().insertEmployee(employees[0]);
            }
            Log.d("dbg", "task is over");
            return null;
        }
    }
}
