package com.he.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notice {
    private Integer id;
    private String name;
    private String content;
    private String times;
}
