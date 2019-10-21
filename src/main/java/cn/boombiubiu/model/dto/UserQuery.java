package cn.boombiubiu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
public class UserQuery {

    @NotBlank(message = "用户id不能为空")
    private String userId;

    @NotBlank(message = "用户名称不能为空")
    private String userName;

    @NotBlank(message = "用户密码不能为空")
    private String userPwd;

    @NotBlank(message = "用户性别不能为空")
    private String userSex;
}
