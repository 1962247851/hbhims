package com.example.hbhims.config.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.enums.ResultCode;
import com.example.hbhims.common.utils.ResultTool;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 会话信息过期策略
 */
@Component
public class CustomizeSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException {
        JsonResult<?> result = ResultTool.fail(ResultCode.USER_ACCOUNT_USE_BY_OTHERS);
        HttpServletResponse httpServletResponse = sessionInformationExpiredEvent.getResponse();
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(result));
    }
}
