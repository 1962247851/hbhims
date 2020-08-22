package com.example.hbhims.service;

import com.alibaba.fastjson.JSONObject;
import com.example.hbhims.dao.SysUserDao;
import com.example.hbhims.entity.MedicalSuggestionRequest;
import com.example.hbhims.entity.SysUser;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Sender;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 19622
 */
@Service
public class PushService {
    private final SysUserDao sysUserDao;

    private static final String APP_SECRET_KEY = "----------";
    private static final String MY_PACKAGE_NAME = "com.example.hbhims";
    private static final String MEDICAL_SUGGESTION_REQUEST = "medical_suggestion_request";

    public PushService(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    public void newMedicalSuggestionRequest(@NotNull MedicalSuggestionRequest medicalSuggestionRequest) throws IOException, ParseException {
        SysUser user = sysUserDao.findById(medicalSuggestionRequest.getUserId()).orElseThrow();
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String title = "新医疗意见和建议请求";
        String description = user.getUserName() + " 邀请你提供医疗意见和建议";
        Message message = buildMessage(Math.toIntExact(medicalSuggestionRequest.getId()), JSONObject.toJSONString(medicalSuggestionRequest), title, description, MEDICAL_SUGGESTION_REQUEST);
        //发送消息到指定设备上
        sender.sendToUserAccount(message, String.valueOf(medicalSuggestionRequest.getProfessionalId()), 3);
    }

    public void recallMedicalSuggestionRequest(@NotNull MedicalSuggestionRequest medicalSuggestionRequest) throws IOException, ParseException {
        SysUser user = sysUserDao.findById(medicalSuggestionRequest.getUserId()).orElseThrow();
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String title = "医疗意见和建议请求撤回提醒";
        String description = user.getUserName() + " 已撤回提供医疗意见和建议的邀请";
        Message message = buildMessage(Math.toIntExact(medicalSuggestionRequest.getId()), null, title, description, MEDICAL_SUGGESTION_REQUEST);
        //发送消息到指定设备上
        sender.sendToUserAccount(message, String.valueOf(medicalSuggestionRequest.getProfessionalId()), 3);
    }

    public void finishMedicalSuggestionRequest(@NotNull MedicalSuggestionRequest medicalSuggestionRequest) throws IOException, ParseException {
        SysUser user = sysUserDao.findById(medicalSuggestionRequest.getProfessionalId()).orElseThrow();
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String title = "医疗意见和建议完成提醒";
        String description = user.getUserName() + " 已提供医疗意见和建议";
        Message message = buildMessage(Math.toIntExact(medicalSuggestionRequest.getId()), null, title, description, MEDICAL_SUGGESTION_REQUEST);
        //发送消息到指定设备上
        sender.sendToUserAccount(message, String.valueOf(medicalSuggestionRequest.getUserId()), 3);
    }

    private Message buildMessage(@NotNull Integer notifyId, @Nullable String payload, @NotNull String title, @NotNull String description, @NotNull String channelId) {
        return new Message.Builder().title(title).description(description).notifyId(notifyId)
                //透传消息可选
                .payload(payload == null ? "" : payload).restrictedPackageName(MY_PACKAGE_NAME)
                // 使用默认提示音提示
                //DEFAULT_SOUND = 1;
                //DEFAULT_VIBRATE = 2;
                //DEFAULT_LIGHTS = 4;
                //DEFAULT_ALL = -1;
                .notifyType(-1)
                // 设置channel id, 必须配
                .extra("channel_id", channelId).build();
    }

}
