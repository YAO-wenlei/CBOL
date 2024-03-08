package org.cbol.user.service.handler;

import org.cbol.common.exception.ClientException;
import org.cbol.user.enums.UserRegisterErrorEnum;
import org.cbol.user.vo.UserRegisterVO;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author yaowenlei
 * @date 2024年01月15日 4:45 下午
 */
@Component
public class UserRegisterParamNotNullChainHandler implements UserinfoCreatChainFilter {

    @Override
    public void handler(UserRegisterVO userRegisterVO) {
        if (Objects.isNull(userRegisterVO.getPhone())){
            throw new ClientException(UserRegisterErrorEnum.PHONE_NOTNULL);
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
