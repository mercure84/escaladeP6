package com.escaladeP6.security;

import com.escaladeP6.DAO.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

//classe qui vérifie la concordance des utilisateurs et de leurs rôles

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MembreRepository membreRepository;

    @




}
