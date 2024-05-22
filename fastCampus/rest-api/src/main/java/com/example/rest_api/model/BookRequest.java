package com.example.rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter //예제에만 사용
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String name;
    private String number;
    private String category;
}
