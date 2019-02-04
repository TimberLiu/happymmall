package com.mmall.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Timber
 * @date 2019/2/1
 */

@Slf4j
public class CookieUtil {

    private static final String COOKIE_DOMAIN = ".happymmall.com";
    private static final String COOKIE_NAME = "mmall_login_token";

    public static String readLoginToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("read cookieName:{}, cookieValue:{}", cookie.getName(), cookie.getValue());
                if (StringUtils.equals(COOKIE_NAME, cookie.getName())) {
                    log.info("return cookieName:{}, cookieValue:{}", cookie.getName(), cookie.getValue());
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void writeLoginToken(HttpServletResponse response, String token) {
        Cookie cookie  = new Cookie(COOKIE_NAME, token);
        cookie.setDomain(COOKIE_DOMAIN);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        // 单位是秒，如果是 -1，代表永久；
        // 如果 MaxAge 不设置，cookie 不会写入硬盘，而是在内存，只在当前页面有效
        cookie.setMaxAge(60 * 60 * 24 * 365);

        log.info("write cookieName:{}, cookieValue:{}", cookie.getName(), cookie.getValue());

        response.addCookie(cookie);
    }

    public static void delLoginToken(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (StringUtils.equals(COOKIE_NAME, cookie.getName())) {
                    cookie.setDomain(COOKIE_DOMAIN);
                    cookie.setPath("/");
                    // maxAge 设置为 0，表示将其删除
                    cookie.setMaxAge(0);
                    log.info("del cookieName:{}, cookieValue:{}", cookie.getName(), cookie.getValue());
                    response.addCookie(cookie);
                    return;
                }
            }
        }
    }

}
