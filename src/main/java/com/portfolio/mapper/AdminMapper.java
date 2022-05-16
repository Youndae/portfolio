package com.portfolio.mapper;

import com.portfolio.VO.AdminVO;
import com.portfolio.VO.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    AdminVO portfolioDetail(int bno) throws Exception;

    void insertProc(AdminVO adminVO) throws Exception;

    AdminVO modifyPort(int bno) throws Exception;

    void modifyProc(AdminVO adminVO) throws Exception;

    void deleteProc(int bno) throws Exception;

    MemberVO getUserInfo(String userId);


}
