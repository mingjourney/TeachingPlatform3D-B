package com.healthy.heathy.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gugu.common.ResultResponse;
import com.gugu.common.UserHolder;
import com.gugu.dto.DateDataForm;
import com.gugu.dto.DatePlanDTO;
import com.gugu.dto.PlanDateDetails;
import com.gugu.dto.UserDTO;
import com.gugu.entity.DatePlan;
import com.gugu.entity.SportType;
import com.healthy.heathy.dao.DatePlanMapper;
import com.healthy.heathy.dao.RecordMapper;
import com.healthy.heathy.feign.UserInfoService;
import com.healthy.heathy.service.RecordService;
import com.gugu.utils.ReturnUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gugu
 * @create 2023-04-29 8:24
 * @purpose
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    RecordMapper recordMapper;

    @Resource
    DatePlanMapper datePlanMapper;
    @Resource
    UserInfoService userInfoService;
    @Override
    @Transactional
    public ResultResponse saveWeightDate(Double weight) {
        UserDTO user = UserHolder.getUser();
        int i = recordMapper.saveWeightDate(weight, user.getId());
        ResultResponse resultResponse = userInfoService.updateWeight(weight);
        System.out.println(resultResponse.toString());
        if("20000".equals(resultResponse.getCode())){
            return ReturnUtil.returnResult(i,"记录成功","记录失败");
        }
        return ResultResponse.error("保存信息失败，请重试");
    }

    @Override
    @Transactional
    public ResultResponse addDateData(DateDataForm data) {
        System.out.println(data);
        UserDTO user = UserHolder.getUser();
        int j = recordMapper.saveDateData(data, user.getId());
        int t = recordMapper.saveSports(data.getSports(),user.getId());
        return ResultResponse.success("保存成功");
    }

    @Override
    public ResultResponse getSportTypes() {
        List<SportType> sports = recordMapper.getSports();
        return ResultResponse.success("获取成功",sports);
    }

    @Override
    public ResultResponse getDatePlanToday(){
        UserDTO user = UserHolder.getUser();
        DatePlan datePlanToday = datePlanMapper.getDatePlanToday(user.getId());
        DatePlanDTO datePlanDTO = new DatePlanDTO();
        BeanUtils.copyProperties(datePlanToday,datePlanDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            datePlanDTO.setTimeSlots(objectMapper.readValue(datePlanToday.getTimeSlots(),new TypeReference<List<PlanDateDetails>>(){}));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResultResponse.success("查询成功",datePlanDTO);
    }
}
