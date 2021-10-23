package com.he.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCar {
    private Integer id;
    private String name;
    private float price;
    private  Integer sums;
}
