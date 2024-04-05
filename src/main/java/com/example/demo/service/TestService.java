package com.example.demo.service;

import com.example.demo.model.dto.EntityProfileDto;
import com.example.demo.util.SingleGeneric;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TestService {

    public void printSimpleGeneric() {
        var myGen = new SingleGeneric<>(EntityProfileDto.builder().build());
        myGen.printAllGenerics();
    }

    public <T> void printGenericParam(T t) {
        var myGen = new SingleGeneric<>(t);
        myGen.printAllGenerics();
    }

}
