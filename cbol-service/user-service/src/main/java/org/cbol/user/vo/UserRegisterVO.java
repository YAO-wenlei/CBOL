package org.cbol.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.database.base.BaseDO;

import java.util.Date;

/**
 * @author yaowenlei
 * @date 2023年12月17日 11:04 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterVO extends BaseDO {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 昵称
     */
    private String name;

    /**
     * 账号
     */
    private String accountNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 1:男 0:女
     */
    private Integer sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 角色id
     */
    private Long roleId;
}
