package com.healthy.heathy.service.Impl;

import com.gugu.common.ResultResponse;
import com.gugu.common.UserHolder;
import com.gugu.dto.TargetForm;
import com.gugu.dto.UserDTO;
import com.healthy.heathy.dao.TargetMapper;
import com.healthy.heathy.service.TargetService;
import com.gugu.utils.JsonUtil;
import com.gugu.utils.ReturnUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Gugu
 * @create 2023-05-01 14:27
 * @purpose
 */
@Service
public class TargetServiceImpl implements TargetService {

    @Resource
    TargetMapper targetMapper;
    @Override
    public ResultResponse addTarget(TargetForm targetForm) {
        String listString = JsonUtil.toJson(targetForm.getGoals());
        UserDTO user = UserHolder.getUser();
        int i = targetMapper.addTarget(targetForm, listString, user.getId());
        return ReturnUtil.returnResult(i,"添加成功","添加失败");
    }
}
