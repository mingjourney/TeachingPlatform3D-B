package com.healthy.heathy.controller;

import com.gugu.common.ResultResponse;
import com.lilittlecat.chatgpt.offical.ChatGPT;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gugu
 * @create 2023-05-05 13:39
 * @purpose
 */
@RestController
@RequestMapping("gpt")
@CrossOrigin
@Api("gpt提问")
public class ChatGPTController {

    @PostMapping("ask")
    @ApiOperation(value = "提问")
    public ResultResponse ask(String question){
        ChatGPT chatGPT = new ChatGPT("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","127.0.0.1", 21002);
        String answer = chatGPT.ask(question);

        return ResultResponse.success("询问成功",answer);
    }

}
