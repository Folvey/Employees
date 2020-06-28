package com.example.employees;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

public class EmployeeViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {
    public EmployeeViewModelFactory(@NonNull Application application) {
        super(application);
    }
}
