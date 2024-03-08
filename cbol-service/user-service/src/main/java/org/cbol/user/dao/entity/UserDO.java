package org.cbol.user.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.database.base.BaseDO;

import java.util.Date;

/**
 * 用户实体类
 * @author yaowenlei
 */
@Data
@TableName("t_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDO extends BaseDO {
    /**
    * 主键
    */
    @TableId(value = "id",type = IdType.AUTO)
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