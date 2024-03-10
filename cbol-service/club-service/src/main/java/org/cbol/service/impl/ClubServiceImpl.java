package org.cbol.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cbol.common.util.BeanUtil;
import org.cbol.dao.entity.ClubDO;
import org.cbol.dao.mapper.ClubMapper;
import org.cbol.service.ClubService;
import org.cbol.vo.ClubInfoVO;
import org.cbol.vo.ClubRegisterRespVO;
import org.cbol.vo.ClubRegisterVO;
import org.springframework.stereotype.Service;

/**
 * 厂牌服务
 * @author yaowenlei
 */
@Service
public class ClubServiceImpl extends ServiceImpl<ClubMapper, ClubDO> implements ClubService {

	@Override
	public ClubRegisterRespVO register(ClubRegisterVO clubRegisterVO) {
		ClubDO clubDO = new ClubDO();
		this.baseMapper.insert(BeanUtil.convert(clubRegisterVO, clubDO));
		return BeanUtil.convert(clubDO, ClubRegisterRespVO.class);
	}

	@Override
	public ClubInfoVO getClubByClubId(Long clubId) {
		return BeanUtil.convert(this.baseMapper.selectById(clubId),ClubInfoVO.class);
	}
	@Override
	public void updateClubInfo(ClubInfoVO clubInfoVO) {
		ClubDO newClubDO = BeanUtil.convert(clubInfoVO, ClubDO.class);
		LambdaUpdateWrapper<ClubDO> updateWrapper = Wrappers.lambdaUpdate(ClubDO.class)
				.eq(ClubDO::getId, clubInfoVO.getId());
		this.baseMapper.update(newClubDO,updateWrapper);
	}

	@Override
	public void delete(Long clubId) {
		this.baseMapper.deleteById(clubId);
	}
}
