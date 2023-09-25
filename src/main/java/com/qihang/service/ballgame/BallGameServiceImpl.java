package com.qihang.service.ballgame;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qihang.common.vo.BaseVO;
import com.qihang.common.vo.CommonListVO;
import com.qihang.controller.ballgame.admin.dto.AdminBallGameDTO;
import com.qihang.controller.ballgame.admin.vo.AdminBallGameVO;
import com.qihang.controller.ballgame.app.dto.BallGameDTO;
import com.qihang.controller.ballgame.app.vo.BallGameVO;
import com.qihang.domain.ballgame.BallGameDO;
import com.qihang.mapper.ballgame.BallGameMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author qihang
 * @since 2022-10-03
 */
@Service
public class BallGameServiceImpl implements IBallGameService {
    @Resource
    private BallGameMapper ballGameMapper;

    @Override
    public CommonListVO<BallGameVO> list(@Valid BallGameDTO ballGame) {

        CommonListVO commonList = new CommonListVO();
        LambdaQueryWrapper<BallGameDO> qw = new QueryWrapper<BallGameDO>().lambda();
        qw.eq(BallGameDO::getTenantId,ballGame.getTid());
        qw.eq(BallGameDO::getLine,0);
        List<BallGameDO> ballGameList = ballGameMapper.selectList(qw);

        List<BallGameVO> list = BeanUtil.copyToList(ballGameList, BallGameVO.class);
        commonList.setVoList(list);
        return commonList;
    }
    @Override
    public  CommonListVO<AdminBallGameVO> adminListall(AdminBallGameDTO adminBallGame){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));
        CommonListVO<AdminBallGameVO> commonList = new CommonListVO<>();
        Page<BallGameDO> page = new Page<>(adminBallGame.getPageNo(), adminBallGame.getPageSize());
        LambdaQueryWrapper<BallGameDO> qw = new QueryWrapper<BallGameDO>().lambda();
        qw.eq(BallGameDO::getTenantId,tid);
        qw.like(StrUtil.isNotBlank(adminBallGame.getName()), BallGameDO::getName, adminBallGame.getName());
        Page<BallGameDO> pageData = ballGameMapper.selectPage(page, qw);
        List<BallGameDO> list = pageData.getRecords();
        List<AdminBallGameVO> shopList = BeanUtil.copyToList(list, AdminBallGameVO.class);
        commonList.setVoList(shopList);
        commonList.setTotal(pageData.getTotal());
        return commonList;


    }

    @Override
    public CommonListVO<AdminBallGameVO> adminList() {
        CommonListVO<AdminBallGameVO> commonList = new CommonListVO<>();
        List<BallGameDO> gameList = ballGameMapper.selectList(null);
        List<AdminBallGameVO> list = BeanUtil.copyToList(gameList, AdminBallGameVO.class);
        commonList.setVoList(list);
        return commonList;
    }

    @Override
    public BaseVO updateLine(Integer id, String type) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        int tid = Integer.parseInt(servletRequestAttributes.getRequest().getHeader("X-Tenant-Id"));
        BallGameDO ballGame = ballGameMapper.selectOne(new QueryWrapper<BallGameDO>().lambda().eq(BallGameDO::getTenantId,tid).eq(BallGameDO::getId,id));
        ballGame.setLine(type);
        ballGameMapper.updateById(ballGame);
        return new BaseVO();
    }
}
