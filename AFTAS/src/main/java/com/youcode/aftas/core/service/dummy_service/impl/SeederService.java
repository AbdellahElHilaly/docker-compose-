package com.youcode.aftas.core.service.dummy_service.impl;

import com.youcode.aftas.core.service.dummy_service.DummyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class SeederService {

    private final DummyService dummyService;

    public void seedAll(int size) {
        dummyService.saveCollection(size);
    }


}
