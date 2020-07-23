package com.securitylogin.demo.security;

//public class UserAuthenticationAccessDeniedHandler {
//}
/*
import com.example.demo.common.JsonData;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
*/
import com.securitylogin.demo.constant.ResponseCode;
import com.securitylogin.demo.result.RestResult;
import com.securitylogin.demo.util.ServletUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by linziyu on 2019/2/13.
 *
 * 无权限操作时的处理类
 */

@Component("UserAccessDeniedHandler")
public class UserAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {
        boolean isAjax = ServletUtil.isAjax();
        //System.out.println("isajax:"+isAjax);
        if (isAjax == true) {
            ServletUtil.printRestResult(RestResult.error(ResponseCode.ACCESS_DENIED));
        } else {
            ServletUtil.printString(ResponseCode.ACCESS_DENIED.getMsg());
        }
    }
}