package com.accolade.nebula.playground;

import com.accolade.nebula.playground.dynamo.NebulaDao;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NebulaService {
    @Autowired
    private NebulaDao nebulaDao;

    public Nebula getById(int id) {
        return nebulaDao.getById(id);
    }

    public Nebula put(Nebula nebula) {
        return nebulaDao.insert(nebula);
    }
}

