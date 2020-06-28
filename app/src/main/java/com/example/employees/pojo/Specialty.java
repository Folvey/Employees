package com.example.employees.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Specialty {
    @SerializedName("specialty_id")
    @Expose
    private int specialtyId;
    @SerializedName("name")
    @Expose
    private String name;

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
