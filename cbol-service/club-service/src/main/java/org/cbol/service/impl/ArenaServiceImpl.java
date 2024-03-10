package org.cbol.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cbol.common.page.PageResponse;
import org.cbol.common.util.BeanUtil;
import org.cbol.dao.entity.ArenaDO;
import org.cbol.dao.mapper.ArenaMapper;
import org.cbol.database.util.PageUtil;
import org.cbol.service.ArenaService;
import org.cbol.vo.ArenaCreateRespVO;
import org.cbol.vo.ArenaCreateVO;
import org.cbol.vo.ArenaInfoVO;
import org.cbol.vo.ArenaPageQueryVO;
import org.springframework.stereotype.Service;

@Service
public class ArenaServiceImpl extends ServiceImpl<ArenaMapper, ArenaDO> implements ArenaService {
	@Override
	public ArenaCreateRespVO creat(ArenaCreateVO arenaCreateVO) {
		ArenaDO arenaDO = new ArenaDO();
		this.baseMapper.insert(BeanUtil.convert(arenaCreateVO, arenaDO));
		return BeanUtil.convert(arenaDO, ArenaCreateRespVO.class);
	}

	@Override
	public ArenaInfoVO getArenaById(Long id) {
		return BeanUtil.convert(this.baseMapper.selectById(id), ArenaInfoVO.class);
	}

	@Override
	public void update(ArenaInfoVO arenaInfoVO) {
		ArenaDO newArenaDO = BeanUtil.convert(arenaInfoVO, ArenaDO.class);
		LambdaUpdateWrapper<ArenaDO> updateWrapper = Wrappers.lambdaUpdate(ArenaDO.class)
				.eq(ArenaDO::getId, arenaInfoVO.getId());
		this.baseMapper.update(newArenaDO, updateWrapper);
	}

	@Override
	public void delete(Long id) {
		this.baseMapper.deleteById(id);
	}

	@Override
	public PageResponse<ArenaInfoVO> pageQuery(ArenaPageQueryVO arenaPageQueryVO) {
		LambdaUpdateWrapper<ArenaDO> updateWrapper = Wrappers.lambdaUpdate(ArenaDO.class)
				.eq(ObjectUtil.isNotEmpty(arenaPageQueryVO.getId()), ArenaDO::getId, arenaPageQueryVO.getId())
				.like(ObjectUtil.isNotEmpty(arenaPageQueryVO.getName()), ArenaDO::getName, arenaPageQueryVO.getName());
		IPage<ArenaDO> iPage = PageUtil.convert(arenaPageQueryVO);
		IPage<ArenaDO> pageResult = this.baseMapper.selectPage(iPage, updateWrapper);
		return PageUtil.convert(pageResult, each -> BeanUtil.convert(each, ArenaInfoVO.class));
	}
}
