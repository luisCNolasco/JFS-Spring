package com.mitocode.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.model.Patient;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPatientRepo;
import com.mitocode.repo.PatientRepoImpl;
import com.mitocode.service.IPatientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements IPatientService {

    //@Autowired
    private final IPatientRepo repo;// = new PatientRepo();
    private final PatientRepoImpl repoImpl;

    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Patient> listPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<Patient> getPatients1(String name) {
        return repoImpl.getPatients1(name);
    }
}
