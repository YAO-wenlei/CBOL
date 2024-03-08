package org.cbol.user.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yaowenlei
 * @date 2023年12月15日 10:58 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVO {

    /**
     * 主键
     */
    private Long id;
    /**
     * 昵称
     */
    private String name;

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
}
