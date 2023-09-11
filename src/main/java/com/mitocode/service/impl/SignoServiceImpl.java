package com.mitocode.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.model.Signo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ISignoRepo;
import com.mitocode.service.ISignoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignoServiceImpl extends CRUDImpl<Signo, Integer>implements ISignoService{

	private final ISignoRepo repo;
	
	@Override
	protected IGenericRepo<Signo, Integer> getRepo() {
		return repo;
	}

	  @Override
	    public Page<Signo> listPage(Pageable pageable) {
	        return repo.findAll(pageable);
	    }
}
