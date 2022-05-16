package com.portfolio.security.domain;

import com.portfolio.VO.MemberVO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Slf4j
public class CustomUser extends User {

    private MemberVO memberVO;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);
    }

    public CustomUser(MemberVO vo){

        super(vo.getUserId(), vo.getUserPw(), vo.getAuthList().stream()
                .map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));

        log.info("Custom User ");
        log.info("info : " + vo.getUserId() + ", AuthList : " + vo.getAuthList());

        this.memberVO = vo;

    }

}
