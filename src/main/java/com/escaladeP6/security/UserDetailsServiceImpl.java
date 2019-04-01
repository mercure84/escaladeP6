package com.escaladeP6.security;

import com.escaladeP6.DAO.AppRoleDAO;
import com.escaladeP6.DAO.MembreRepository;
import com.escaladeP6.beans.Membre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//classe qui vérifie la concordance des utilisateurs et de leurs rôles

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MembreRepository membreRepository;

    @Autowired
    private AppRoleDAO appRoleDAO;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
        Membre membre = this.membreRepository.findMembreByPseudo(pseudo);

        if (membre == null) {
            logger.warn("User not found! " + pseudo);
            throw new UsernameNotFoundException("User " + pseudo + " was not found in the database");
        }

        logger.info("Found User: " + membre);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.appRoleDAO.getRoleNames(membre.getId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(membre.getPseudo(), membre.getEncryptedPassword(), grantList);

        return userDetails;

    }


}
