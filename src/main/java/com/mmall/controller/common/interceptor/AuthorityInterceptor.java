package com.mmall.controller.common.interceptor;

import com.google.common.collect.Maps;
import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.util.CookieUtil;
import com.mmall.util.JsonUtil;
import com.mmall.util.RedisShardedPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Timber
 * @date 2019/2/8
 */

@Slf4j
public class AuthorityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        log.info("preHandle");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String methodName = handlerMethod.getMethod().getName();
        String className = handlerMethod.getBean().getClass().getSimpleName();

        StringBuilder requestParamBuilder = new StringBuilder();
        Map paramMap = httpServletRequest.getParameterMap();
        Iterator iter = paramMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String mapKey = (String) entry.getKey();

            String mapValue = StringUtils.EMPTY;
            Object obj = entry.getValue();
            if (obj instanceof String[]) {
                String[] strs = (String[])obj;
                mapValue = Arrays.toString(strs);
            }
            requestParamBuilder.append(mapKey).append("=").append(mapValue);
        }

        if (StringUtils.equals(className, "UserManageController") || StringUtils.equals(methodName, "login")) {
            log.info("权限拦截器拦截到请求，className:{}, MethodName:{}", className, methodName);
            return true;
        }

        User user = null;
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if (StringUtils.isNotEmpty(loginToken)) {
            String userJsonStr = RedisShardedPoolUtil.get(loginToken);
            user = JsonUtil.str2Obj(userJsonStr, User.class);
        }

        if (user == null || (user.getRole() != Const.Role.ROLE_ADMIN)) {
            httpServletResponse.reset(); // 重置 reset，否则会出现异常
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json;charset=UTF-8");

            PrintWriter out = httpServletResponse.getWriter();

            if (user == null) {
                if (StringUtils.equals(className, "ProductManageController") || StringUtils.equals(methodName, "richTextImgUpload")) {
                    Map resultMap = Maps.newHashMap();
                    resultMap.put("success", false);
                    resultMap.put("msg", "请登录");
                    out.print(JsonUtil.obj2Str(resultMap));
                } else {
                    out.print(JsonUtil.obj2Str(ServerResponse.createByErrorMessage("拦截器未拦截，用户未登录")));
                }
            } else {
                if (StringUtils.equals(className, "ProductManageController") || StringUtils.equals(methodName, "richTextImgUpload")) {
                    Map resultMap = Maps.newHashMap();
                    resultMap.put("success", false);
                    resultMap.put("msg", "无权限操作");
                    out.print(JsonUtil.obj2Str(resultMap));
                } else {
                    out.print(JsonUtil.obj2Str(ServerResponse.createByErrorMessage("拦截器未拦截，用户无权限")));
                }
            }
            out.flush();
            out.close();

            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("postHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("afterCompletion");
    }

}
