package com.he.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    private Integer id;

    private String name;

    private String pwd;

    private String realname;

    private String sex;

    private Integer age;

    private String card;

    private String address;

    private String phone;

    private String email;

    private String code;

    private Integer type;

}
