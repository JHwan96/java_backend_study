package com.example.memorydb.book.db.entity;

import com.example.memorydb.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class BookEntity extends Entity {
    private String name;
    private String category;
    private BigDecimal amount;
}
