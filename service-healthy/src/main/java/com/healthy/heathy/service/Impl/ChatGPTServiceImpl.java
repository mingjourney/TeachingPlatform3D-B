package com.healthy.heathy.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gugu.common.Prompt;
import com.gugu.common.ResultResponse;
import com.gugu.dto.DatePlanDTO;
import com.gugu.dto.SignInForm;
import com.healthy.heathy.feign.UserInfoService;
import com.healthy.heathy.service.ChatGPTService;
import com.lilittlecat.chatgpt.offical.ChatGPT;
import com.lilittlecat.chatgpt.offical.entity.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Gugu
 * @create 2023-05-06 20:19
 * @purpose
 */

@Service
public class ChatGPTServiceImpl implements ChatGPTService {
    @Resource
    ChatGPT chatGPT;

    @Resource
    UserInfoService userInfoService;

    @Override
    public ResultResponse getDatePlan(Integer level) throws JsonProcessingException {
        String description = "";
        if(level==1){
            description = "用户选择了简单模式，请安排一些轻松的日程";
        }else if(level==3){
            description = "用户选择了日常模式，请安排一些适合用户体质及目标的的日程";
        }else{
            description = "用户选择了加练模式，今天他很有精神，由于他选择了加练，我们在之后的日计划中要注意减负，避免对身体造成过度负担。";
        }
        SignInForm user = userInfoService.getUserInfo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        String prompt = "请帮用户名为“"+user.getNickname()+"”的用户定制日计划；其中他之前设立的目标如下，在2023.6月瘦到64kg,并且健身入门；下面是截止昨天平台保存的这位用户的数据，"+user.getNickname()+"，身高"+user.getHeight()+
                "cm，体重"+user.getWeight()+"kg,年龄"+user.getAge()+"岁，性别"+user.getSex()+"，"+user.getProfession()+
                "，爱好是"+user.getHobby()+"，由于"+description+"，请制定"+format+"的日计划（只有json形式，不要其他语句）";
        List<Message> messages = new ArrayList<>();
        messages.add(Message.builder()
                .role("user")
                .content(Prompt.datePlan)
                .build());

        messages.add(Message.builder()
                .role("user")
                .content(prompt)
                .build());
        String ans = chatGPT.ask(messages);
        ObjectMapper objectMapper = new ObjectMapper();
        DatePlanDTO datePlanDTO = objectMapper.readValue(ans, DatePlanDTO.class);
        return ResultResponse.success("查询成功",datePlanDTO);
    }
}
