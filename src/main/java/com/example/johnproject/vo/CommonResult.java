package com.example.johnproject.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommonResult <T>{
    private int code;
    private String info;
    private T content;
}
