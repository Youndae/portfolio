package com.portfolio.controller;

import com.portfolio.VO.AdminVO;
import com.portfolio.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.UUID;

@RestController
public class AdminController {

    @Autowired(required = false)
    AdminMapper mapper;

    @PostMapping("/file_uploader_html5.do")
    @ResponseBody
    public String editorFileUpload(HttpServletRequest request){

        StringBuffer sb = new StringBuffer();
        try {

            String oldName = request.getHeader("file-name");

            String filePath = request.getSession().getServletContext().getRealPath("image/");
            String saveName = sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis()))
                    .append(UUID.randomUUID().toString())
                    .append(oldName.substring(oldName.lastIndexOf("."))).toString();

            InputStream is = request.getInputStream();

            OutputStream os = new FileOutputStream(filePath + saveName);
            int numRead;
            byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
            while ((numRead = is.read(b, 0, b.length)) != -1) {
                os.write(b, 0, numRead);
            }
            os.flush();
            os.close();

            sb = new StringBuffer();
            sb.append("&bNewLine=true")
                    .append("&sFileName=").append(oldName)
                    .append("&sFileURL=").append("/upImg/").append(saveName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @PostMapping("/insertProc")
    public int portInsert(AdminVO adminVO) throws Exception{

        mapper.insertProc(adminVO);

        return 1;
    }

    @PostMapping("/modifyProc")
    public int portModify(AdminVO adminVO) throws Exception{

        System.out.println(adminVO);

        mapper.modifyProc(adminVO);

        return 1;
    }

    @PostMapping("/deletePort")
    public int deletePort(int bno) throws Exception{
        System.out.println("controller bno : " + bno);

        mapper.deleteProc(bno);

        return 0;
    }
}
