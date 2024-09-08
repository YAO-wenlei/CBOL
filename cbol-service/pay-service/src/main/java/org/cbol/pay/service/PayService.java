package org.cbol.pay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.cbol.pay.dao.entity.PayDO;
import org.cbol.pay.dto.PayCreateResp;
import org.cbol.pay.dto.PayRequest;

public interface PayService extends IService<PayDO> {
    PayCreateResp pay(PayRequest payRequest);
}
