package org.cbol.user.service.handler;

import org.cbol.framework.starter.chain.AbstractChainHandler;
import org.cbol.user.enums.UserChainFilterEnum;
import org.cbol.user.vo.UserRegisterVO;

/**
 * @author yaowenlei
 */
public interface UserinfoCreatChainFilter extends AbstractChainHandler<UserRegisterVO> {
    
    @Override
    default String mark() {
        return UserChainFilterEnum.USER_REGISTER_FILTER.name();
    }

}
