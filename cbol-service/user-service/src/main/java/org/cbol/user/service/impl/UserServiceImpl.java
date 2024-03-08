package org.cbol.user.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.cbol.common.page.PageResponse;
import org.cbol.common.util.BeanUtil;
import org.cbol.database.util.PageUtil;
import org.cbol.framework.starter.chain.AbstractChainContext;
import org.cbol.user.dao.entity.UserDO;
import org.cbol.user.dao.mapper.UserMapper;
import org.cbol.user.service.UserService;
import org.cbol.user.vo.UserInfoVO;
import org.cbol.user.vo.UserPageQueryVO;
import org.cbol.user.vo.UserRegisterRespVO;
import org.cbol.user.vo.UserRegisterVO;
import org.springframework.stereotype.Service;

/**
 * @author yaowenlei
 * @date 2023年12月03日 1:52 下午
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final AbstractChainContext abstractChainContext;

    private final UserMapper userMapper;

    @Override
    public UserInfoVO queryUserById(Long id) {
        return BeanUtil.convert(userMapper.selectById(id),UserInfoVO.class);
    }

    @Override
    public UserRegisterRespVO register(UserRegisterVO userRegisterVO) {
        //todo 用户注册参数校验
        UserDO userDO = new UserDO();
        userMapper.insert(BeanUtil.convert(userRegisterVO, userDO));
        return BeanUtil.convert(userDO, UserRegisterRespVO.class);
    }

    @Override
    public Integer deleteUserById(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer update(UserInfoVO userInfoVO) {
        return userMapper.updateById(BeanUtil.convert(userInfoVO, UserDO.class));
    }

    @Override
    public PageResponse<UserInfoVO> pageUserInfo(UserPageQueryVO requestParam) {
        LambdaQueryWrapper<UserDO> queryWrapper = new LambdaQueryWrapper<>(UserDO.class)
                .eq(ObjectUtil.isNotEmpty(requestParam.getId()),UserDO::getId, requestParam.getId())
                .like(ObjectUtil.isNotEmpty(requestParam.getName()),UserDO::getName, requestParam.getName())
                .like(ObjectUtil.isNotEmpty(requestParam.getPhone()),UserDO::getPhone, requestParam.getPhone())
                .eq(ObjectUtil.isNotEmpty(requestParam.getAge()),UserDO::getAge, requestParam.getAge())
                .eq(ObjectUtil.isNotEmpty(requestParam.getSex()),UserDO::getSex, requestParam.getSex())
                .eq(ObjectUtil.isNotEmpty(requestParam.getBirthday()),UserDO::getBirthday, requestParam.getBirthday());
        IPage<UserDO> iPage = userMapper.selectPage(PageUtil.convert(requestParam), queryWrapper);

        return PageUtil.convert(iPage,each -> BeanUtil.convert(each, UserInfoVO.class));
    }
}
