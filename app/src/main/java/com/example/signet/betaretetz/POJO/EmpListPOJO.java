
package com.example.signet.betaretetz.POJO;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmpListPOJO {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("employees")
    @Expose
    private List<Employee> employees = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
