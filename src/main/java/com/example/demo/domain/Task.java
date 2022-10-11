package com.example.demo.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter

public class Task {
    private Integer id;
    private String task;
    private String status;
}
