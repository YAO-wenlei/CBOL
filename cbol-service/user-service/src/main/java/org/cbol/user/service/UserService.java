package org.cbol.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.cbol.common.page.PageResponse;
import org.cbol.user.dao.entity.UserDO;
import org.cbol.user.vo.UserInfoVO;
import org.cbol.user.vo.UserPageQueryVO;
import org.cbol.user.vo.UserRegisterRespVO;
import org.cbol.user.vo.UserRegisterVO;

/**
 * @author yaowenlei
 */
public interface UserService extends IService<UserDO> {
    /**
     * 根据用户id查询用户信息
     * @param id 用户ID
     * @return 用户详情
     */
    UserInfoVO queryUserById(Long id);

    /**
     * 注册用户信息
     * @param userRegisterVO
     * @return
     */
    UserRegisterRespVO register(UserRegisterVO userRegisterVO);

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    Integer deleteUserById(Long id);


    Object update(UserInfoVO userInfoVO);

    /**
     * 分页查询用户信息
     * @param pageQueryVO
     * @return
     */
    PageResponse<UserInfoVO> pageUserInfo(UserPageQueryVO pageQueryVO);
}
