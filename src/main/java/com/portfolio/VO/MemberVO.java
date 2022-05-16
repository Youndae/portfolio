package com.portfolio.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

    private String userId;
    private String userPw;

    private List<AuthVO> authList;

}
