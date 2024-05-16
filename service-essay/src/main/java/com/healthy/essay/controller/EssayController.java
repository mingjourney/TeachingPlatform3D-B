package com.healthy.essay.controller;

import com.gugu.common.ResultResponse;
import com.gugu.dto.EssaySearchDTO;
import com.healthy.essay.service.EssayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Gugu
 * @create 2023-05-03 9:06
 * @purpose
 */
@RestController
@RequestMapping("essay")
@CrossOrigin
@Api("文章")
public class EssayController {

    @Resource
    EssayService essayService;

    @GetMapping("getEssayTypeByUser")
    @ApiOperation("获取用户推荐类型")
    public ResultResponse getEssayType(){
        return essayService.getEssayTypeByUser(true);
    }

    @GetMapping("getEssayCommendByUser")
    @ApiOperation("获取推荐文章")
    public ResultResponse getEssayCommendByUser(){
        return essayService.getEssayCommendByUser();
    }

//    @ApiOperation("从py中获取推荐文章")
//    @PostMapping("/getEssayFromPy")
//    public ResultResponse getEssayCommendByUser(@RequestBody Map<String, Integer> requestBody) {
//        Integer userId = requestBody.get("userId");
//        return essayService.getEssayCommendByUserFromPy(userId);
//    }

    @GetMapping("getEssayTypeAll")
    @ApiOperation("获取所有文章类型")
    public ResultResponse getEssayTypeAll(){
        return essayService.getEssayTypeByUser(false);
    }

    @GetMapping("getEssayByType")
    @ApiOperation("通过文章类型获取文章列表")
    public ResultResponse getEssayListByType(Integer type){
        return essayService.getEssayListByType(type);
    }

    @PostMapping("getEssaysByInfo")
    @ApiOperation("通过文章类型获取文章列表")
    public ResultResponse getEssayListByInfo(@RequestBody EssaySearchDTO essaySearchDTO){
        System.out.println();
        return essayService.getEssayListByInfo(essaySearchDTO);
    }

    @GetMapping("getEssayDetailById")
    @ApiOperation("通过文章id获取文章")
    public ResultResponse getEssayById(Integer courseId, @RequestHeader(value = "x-auth-token", required = false) String token){
        return essayService.getEssayById(courseId,token);
    }
    // 添加收藏接口
    @PostMapping("addUserFavorite")
    @ApiOperation("用户添加收藏")
    public ResultResponse addUserFavorite(Integer essayId) {
        return essayService.addUserFavorite(essayId);
    }


    @PostMapping("addComment")
    @ApiOperation("添加评论")
    public ResultResponse addComment( @RequestParam("essayId") int essayId,
                                      @RequestParam("comment") String comment) {
        return essayService.addComment(essayId,comment);
    }

    @GetMapping("getComments")
    public ResultResponse getEssayComments(Integer essayId) {
        return essayService.getEssayComments(essayId);
    }


    // 删除收藏接口
    @PostMapping("deleteUserFavorite")
    @ApiOperation("用户删除收藏")
    public ResultResponse deleteUserFavorite(Integer essayId) {
        return essayService.deleteUserFavorite(essayId);
    }

    // 获取用户收藏接口
    @GetMapping("getUserFavorites")
    @ApiOperation("获取用户收藏列表")
    public ResultResponse getUserFavorites() {
        return essayService.getUserFavoritesByUserId();
    }


    @GetMapping("getUserBrowseHistory")
    @ApiOperation("获取用户浏览记录列表")
    public ResultResponse getUserBrowseHistory() {
        return essayService.getUserBrowseHistoryByUserId();
    }

}
