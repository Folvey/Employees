package com.example.employees.api;

import com.example.employees.pojo.Employee;
import com.example.employees.pojo.EmployeeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("db")
    Observable<EmployeeResponse> getEmployees();



}
