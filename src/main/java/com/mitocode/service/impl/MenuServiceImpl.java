package com.mitocode.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.model.Menu;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IMenuRepo;
import com.mitocode.service.IMenuService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends CRUDImpl<Menu, Integer> implements IMenuService {

    private final IMenuRepo repo;

    @Override
    protected IGenericRepo<Menu, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Menu> getMenusByUsername(String username) {
        //String contextSessionUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return repo.getMenusByUsername(username);
    }
}
