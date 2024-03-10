package org.cbol.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.cbol.dao.entity.ClubDO;
import org.cbol.vo.ClubInfoVO;
import org.cbol.vo.ClubRegisterRespVO;
import org.cbol.vo.ClubRegisterVO;

/**
 * @author yaowenlei
 */
public interface ClubService extends IService<ClubDO> {

	/**
	 * 注册厂牌
	 */
	ClubRegisterRespVO register(ClubRegisterVO clubRegisterVO);

	/**
	 * 查询厂牌信息
	 */
	ClubInfoVO getClubByClubId(Long clubId);

	/**
	 * 更新厂牌信息
	 */
	void updateClubInfo(ClubInfoVO clubInfoVO);

	/**
	 * 删除厂牌
	 */
	void delete(Long clubId);


}
