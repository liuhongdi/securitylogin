package com.securitylogin.demo.security;

        import com.securitylogin.demo.constant.ResponseCode;
        import com.securitylogin.demo.pojo.SysUser;
        import com.securitylogin.demo.result.RestResult;
        import com.securitylogin.demo.util.ServletUtil;
        import org.springframework.security.core.AuthenticationException;
        import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
        import org.springframework.stereotype.Component;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

/**
 * Created by linziyu on 2019/2/9.
 *
 * 用户认证失败处理类
 */

@Component("UserLoginFailureHandler")
public class UserLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        //System.out.println("UserLoginFailureHandler");
        ServletUtil.printRestResult(RestResult.error(ResponseCode.LOGIN_FAIL));
    }
}