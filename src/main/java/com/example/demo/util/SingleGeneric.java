package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class SingleGeneric<T> {

    private T item1;

    public void printAllGenerics() {
        log.info(String.format(">>>> Generic: %s", item1));
        log.info(String.format(">>>> Class type is: %s", item1.getClass().getName()));
    }

}
