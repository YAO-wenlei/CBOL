package org.cbol.user.controller;

import lombok.RequiredArgsConstructor;
import org.cbol.common.page.PageResponse;
import org.cbol.common.result.Result;
import org.cbol.common.result.Results;
import org.cbol.user.service.UserService;
import org.cbol.user.vo.UserInfoVO;
import org.cbol.user.vo.UserPageQueryVO;
import org.cbol.user.vo.UserRegisterRespVO;
import org.cbol.user.vo.UserRegisterVO;
import org.springframework.web.bind.annotation.*;

/**
 * @author yaowenlei
 * @date 2023年12月03日 12:58 下午
 */
@RestController
@RequestMapping("/api/user-service")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserService userService;

    /**
     * 根据用户id查询用户信息
     */
    @GetMapping("/query/{id}")
    public Result<UserInfoVO> getUser(@PathVariable("id") Long id) {
        return Results.success(userService.queryUserById(id));
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/update")
    public Result<Void> updateUserInfo(@RequestBody UserInfoVO userInfoVO) {
        userService.update(userInfoVO);
        return Results.success();
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/delete/{id}")
    public Result<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return Results.success();
    }

    /**
     * 注册用户
     */
    @PostMapping("/register")
    public Result<UserRegisterRespVO> register(@RequestBody UserRegisterVO userRegisterVO) {
        return Results.success(userService.register(userRegisterVO));
    }

    /**
     * 分页查询用户信息
     */
    @PostMapping("/page")
    public Result<PageResponse<UserInfoVO>> pageUserInfo(UserPageQueryVO pageQueryVO) {
        return Results.success(userService.pageUserInfo(pageQueryVO));
    }

}
