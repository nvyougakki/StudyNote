package com.uniware.service;

import com.uniware.bean.Role;
import com.uniware.dao.repository.RoleRepository;
import com.uniware.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName MyUserDetailServiceImp
 * @Description TODO
 * @Author heyu
 * @Date 2019/9/20 13:44
 */
@Configuration
public class MyUserDetailServiceImp implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRep;

    @Autowired
    RoleRepository roleRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.uniware.bean.User user = userRep.findByUserName(username);
        if(user == null)
            return null;
        String pwd = user.getPassword();
        //List<Role> roles = roleRep.findByUserId(user.getId());
        return new User(username, pwd, AuthorityUtils.createAuthorityList("ROLE_USER"));
    }

    public Collection<? extends GrantedAuthority> roleListToAuth(List<Role> roles){
        Collection<GrantedAuthority> result = new HashSet<>();
      /*  for(Role role : roles) {
            result.add(new SimpleGrantedAuthority(role.get));
        }*/
      return result;
    }
}
