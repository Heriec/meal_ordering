package com.he.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Menus {
    private Integer id;
    private String name;
    private String types;
    private String burden;
    private String brief;
    private float price;
    private Integer sums;
    private float price1;
    private Integer sums1;
    private String imgpath;
}
