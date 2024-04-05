package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingleGeneric<T> {
    T item1;
}
