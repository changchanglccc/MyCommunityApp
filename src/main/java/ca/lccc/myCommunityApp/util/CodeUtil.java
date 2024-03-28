package ca.lccc.myCommunityApp.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    /**
     * 检查验证码是否和预期相符
     */
    public static boolean checkVerifyCode(HttpServletRequest request) {
        // 拿到kaptcha生成的验证码
        String verifyCodeExpected = (String) request.getSession()
                .getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        // 拿到用户在前端输入的验证码
        String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");

        if (verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
            return false;
        }

        return true;
    }
}
