package com.project.transfurdfarms.services;

import com.project.transfurdfarms.dto.FarmRegistrationDTO;
import com.project.transfurdfarms.serviceImplementation.FarmRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserInfoDetailsService implements UserDetailsService {


    @Autowired
    FarmRegistrationServiceImpl farmRegistrationService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

       FarmRegistrationDTO user =  farmRegistrationService.findByEmail(email);

       if(user == null){

           throw new UsernameNotFoundException("User with email " + email + " not found");
       }

       return new User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }


    private Collection<GrantedAuthority> getAuthorities(FarmRegistrationDTO farm){


        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities = AuthorityUtils.createAuthorityList(farm.getRoles());

        return authorities;
    }
}
