package com.example.backend.security.service;

import com.example.backend.common.exception.ErrorResult;
import com.example.backend.common.exception.GlobalException;
import com.example.backend.entity.QUserEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.backend.entity.QUserEntity.*;

@Component("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final JPAQueryFactory queryFactory;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserEntity> result = queryFactory.select(userEntity).from(userEntity).where(userEntity.email.eq(username)).fetch();

        // 존재하지 않은 유저
        if(result.isEmpty()){
            throw new GlobalException(HttpStatus.BAD_REQUEST, ErrorResult.NOT_FOUND_EMAIL.getMessage());
        }
        return createUser(result.get(0));
    }

    private User createUser(UserEntity userEntity){
        List<GrantedAuthority> grantedAuthorities =
                userEntity.getAuthorities().stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName())).collect(Collectors.toList());

        return new User(userEntity.getEmail(), userEntity.getPassword(), grantedAuthorities);
    }
}
