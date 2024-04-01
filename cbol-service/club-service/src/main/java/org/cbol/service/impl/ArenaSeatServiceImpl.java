package org.cbol.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cbol.dao.entity.ArenaSeatDO;
import org.cbol.dao.mapper.ArenaSeatMapper;
import org.cbol.service.ArenaSeatService;
import org.springframework.stereotype.Service;

@Service
public class ArenaSeatServiceImpl extends ServiceImpl<ArenaSeatMapper, ArenaSeatDO> implements ArenaSeatService {
}
