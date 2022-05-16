package com.portfolio.security;

import com.portfolio.VO.MemberVO;
import com.portfolio.mapper.AdminMapper;
import com.portfolio.security.domain.CustomUser;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Setter(onMethod_ = {@Autowired})
    private AdminMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberVO vo = mapper.getUserInfo(username);

        return vo == null ? null : new CustomUser(vo);
    }
}
