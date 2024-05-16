package com.gugu.controller;

import com.gugu.common.ResultResponse;

import com.gugu.dto.ClassroomDTO;
import com.gugu.service.ClassroomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gugu
 * @create 2023-04-23 22:00
 * @purpose
 */
@RestController
@RequestMapping("classroom")
@CrossOrigin
@Api("教室")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @GetMapping("getClassroomList")
    @ApiOperation(value = "获取所有教室")
    public ResultResponse getClassroomList(
            @RequestParam(defaultValue = "1") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return classroomService.getClassroomList(pageIndex, pageSize);
    }


    @GetMapping("getClassroomDetailById")
    @ApiOperation(value = "根据id获取教室详情")
    public ResultResponse getClassroomDetailById(Integer id){
        return classroomService.getClassroomDetailById(id);
    }

    @PostMapping("addClassroom")
    @ApiOperation(value = "添加教室")
    public ResultResponse addClassroom(@RequestBody ClassroomDTO classroom){
        return classroomService.addClassroom(classroom);
    }

    @GetMapping("getRecommendedClassroom")
    @ApiOperation(value = "获取推荐算法教室结果")
    public ResultResponse getRecommendedClassroom(){
        return classroomService.getRecommendedClassroom();
    }

    @GetMapping("getUserCourseHistory")
    @ApiOperation("获取用户观看课程记录")
    public ResultResponse getUserCourseHistory() {
        return classroomService.getUserCourseHistory();
    }
}
