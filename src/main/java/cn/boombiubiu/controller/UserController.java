package cn.boombiubiu.controller;

import cn.boombiubiu.model.dto.UserQuery;
import cn.boombiubiu.model.vo.Response;
import cn.boombiubiu.model.domain.User;
import cn.boombiubiu.service.impl.UserServiceImpl;
import cn.boombiubiu.enums.ResponseCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @GetMapping(value = "/getUserList")
    public Response getUserList (
            @RequestParam (value = "userId") @NotBlank (message = "用户id不能为空") String userId) {
        List<User> userList = userService.userList();
        return new Response(ResponseCode.OK, userList);
    }


    @PostMapping(value = "/queryUserById", consumes = "application/json", produces = "application/json")
    public Response queryUserById(@RequestBody @Valid UserQuery userQuery) {
        User user = userService.queryUserById(userQuery.getUserId());
        return new Response(ResponseCode.OK, user);
    }
}
