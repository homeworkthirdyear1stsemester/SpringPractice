package com.kkh.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

    private String firstName;

    // 객체에 값 저장된후 다음 validation 할 때 필요
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required") // add validation rule
    private String lastName;

    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    private int freePasses;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFreePasses() {
        return this.freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }
}
