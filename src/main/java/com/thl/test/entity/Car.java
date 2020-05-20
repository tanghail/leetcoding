package com.thl.test.entity;


import com.thl.test.annotation.Controller;
import com.thl.test.annotation.ResultMapping;

@Controller
public class Car {

    @ResultMapping(value = "test01", madeInChina = false, name = "baoma")
    public void buyCar(){
        System.out.println("i want to buy a car using to take my kids to go to school.....");
    }

    @ResultMapping(value = "test02", madeInChina = true)
    public void sellCar(){
        System.out.println("i will sell my car next week");
    }


}
