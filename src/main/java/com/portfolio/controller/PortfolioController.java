package com.portfolio.controller;

import com.portfolio.VO.AdminVO;
import com.portfolio.mapper.AdminMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
@Slf4j
public class PortfolioController {

    AdminMapper mapper;

    PasswordEncoder pwEncoder;

    @GetMapping("/")
    public String main(){
        return "th/portfolio/main";
    }


    @GetMapping("/admin/insert")
    public String insert(Model model) throws Exception{

        log.info("insert Page");

        return "th/admin/insert";
    }

    @GetMapping("/admin/modify/{bno}")
    public String modify(Model model, @PathVariable("bno") int bno) throws Exception{

        model.addAttribute("modifyPort", mapper.modifyPort(bno));

        return "th/admin/modify";
    }

    @GetMapping("/portfolioDetail/{bno}")
    public ResponseEntity<AdminVO> portfolioDetail(@PathVariable("bno") String bno) throws Exception{
        log.info("port Detail Controller");

        log.info("detail bno : " + bno);

        int no = Integer.parseInt(bno);

        return new ResponseEntity<>(mapper.portfolioDetail(no), HttpStatus.OK);
    }
}
