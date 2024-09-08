package org.cbol.pay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.cbol.cache.DistributedCache;
import org.cbol.common.util.BeanUtil;
import org.cbol.framework.starter.strategy.StrategyExecuteChoose;
import org.cbol.pay.dao.PayMapper;
import org.cbol.pay.dao.entity.PayDO;
import org.cbol.pay.dto.PayCreateResp;
import org.cbol.pay.dto.PayRequest;
import org.cbol.pay.dto.PayResponse;
import org.cbol.pay.enums.TradeStatusEnum;
import org.cbol.pay.service.PayService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PayServiceImpl extends ServiceImpl<PayMapper, PayDO> implements PayService {

    private final DistributedCache distributedCache;

    private final StrategyExecuteChoose strategyExecuteChoose;


    @Override
    public PayCreateResp pay(PayRequest payRequest) {

        PayResponse payResponse = strategyExecuteChoose.chooseAndExecuteResp(payRequest.mark(), payRequest);
        PayDO insertPayDo = BeanUtil.convert(payRequest, PayDO.class);
        //后续雪花算法生成
        String paySn = UUID.randomUUID().toString().replace("-", "");
        insertPayDo.setPaySn(paySn);
        insertPayDo.setStatus(TradeStatusEnum.PENDING_PAYMENT.getCode());


        return null;
    }
}
