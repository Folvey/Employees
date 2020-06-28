package com.example.employees.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.employees.pojo.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {
    static final String DB_NAME = "employees.db";

    @Query("SELECT * FROM employees")
    LiveData<List<Employee>> getAllEmployees();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmployees(List<Employee> employees);

    @Insert
    void insertEmployee(Employee employee);

    @Query("DELETE FROM employees")
    void deleteAllEmployees();

}
