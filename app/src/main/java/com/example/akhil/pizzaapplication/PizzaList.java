package com.example.akhil.pizzaapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PizzaList {

    @SerializedName("pizzaType")
    public List<Pizza> pizza;


    public class Pizza {
        @SerializedName("type")
        public String type;

        @SerializedName("size")
        public String size;
    }
}
