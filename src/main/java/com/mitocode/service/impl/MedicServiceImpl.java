package com.mitocode.service.impl;

import org.springframework.stereotype.Service;

import com.mitocode.model.Medic;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IMedicRepo;
import com.mitocode.service.IMedicService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicServiceImpl extends CRUDImpl<Medic, Integer> implements IMedicService {

    //@Autowired
    private final IMedicRepo repo;// = new MedicRepo();

    @Override
    protected IGenericRepo<Medic, Integer> getRepo() {
        return repo;
    }

}
