package org.cbol.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cbol.common.page.PageResponse;
import org.cbol.common.util.BeanUtil;
import org.cbol.dao.entity.ClubDO;
import org.cbol.dao.mapper.ClubMapper;
import org.cbol.database.util.PageUtil;
import org.cbol.service.ClubService;
import org.cbol.vo.ClubInfoVO;
import org.cbol.vo.ClubPageQueryVO;
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

	@Override
	public PageResponse<ClubInfoVO> pageQuery(ClubPageQueryVO clubPageQueryVO) {
		LambdaQueryWrapper<ClubDO> queryWrapper = Wrappers.lambdaQuery(ClubDO.class)
				.eq(ObjectUtil.isNotEmpty(clubPageQueryVO.getId()), ClubDO::getId, clubPageQueryVO.getId())
				.like(ObjectUtil.isNotEmpty(clubPageQueryVO.getName()), ClubDO::getName, clubPageQueryVO.getName());
		IPage<ClubDO> iPage = PageUtil.convert(clubPageQueryVO);
		return PageUtil.convert(
				this.baseMapper.selectPage(iPage,queryWrapper),
				each -> BeanUtil.convert(each, ClubInfoVO.class));
	}
}
