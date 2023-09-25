package com.qihang.service.wirthdrawalconfig;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qihang.common.vo.BaseVO;
import com.qihang.controller.wirthdrawalconfig.dto.wirthdrawalconfigDTO;
import com.qihang.controller.wirthdrawalconfig.vo.wirthdrawalconfigVO;
import com.qihang.domain.withdrawalconfig.WirthdrawalconfigDO;
import com.qihang.mapper.wirthdrawalconfig.WirthdrawalconfigMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class WirthdrawalconfigServicempl implements IWirthdrawalconfigService {
    @Resource
    private WirthdrawalconfigMapper wirthdrawalconfigMapper;
    @Override
    public wirthdrawalconfigVO edit(wirthdrawalconfigDTO withdrawalDTO) {

        WirthdrawalconfigDO withdrawal = wirthdrawalconfigMapper.selectOne(new QueryWrapper<WirthdrawalconfigDO>().lambda().eq(WirthdrawalconfigDO::getShopId, withdrawalDTO.getShopId()));
        wirthdrawalconfigVO withvo = new wirthdrawalconfigVO();
        withvo.setType(withdrawal.getType());
        withvo.setMaxmoney(withdrawal.getMaxmoney());
        withvo.setWithdrawalfrequency(withdrawal.getWithdrawalfrequency());
        withvo.setMinmoney(withdrawal.getMinmoney());
        withvo.setWithdrawalSwitch(withdrawal.getWithdrawalSwitch());
        return withvo;
    }

    @Override
    public BaseVO updata(wirthdrawalconfigDTO withdrawalDTO) {
        WirthdrawalconfigDO withdrawal = wirthdrawalconfigMapper.selectOne(new QueryWrapper<WirthdrawalconfigDO>().lambda().eq(WirthdrawalconfigDO::getShopId, withdrawalDTO.getId()));
        withdrawal.setType(withdrawalDTO.getType());
        withdrawal.setMaxmoney(withdrawalDTO.getMaxmoney());
        withdrawal.setIsaccount(withdrawalDTO.getIsaccount());
        withdrawal.setState(withdrawalDTO.getState());
        withdrawal.setWithdrawalfrequency(withdrawalDTO.getWithdrawalfrequency());
        withdrawal.setMinmoney(withdrawalDTO.getMinmoney());
        withdrawal.setWithdrawalSwitch(withdrawalDTO.getWithdrawalSwitch());
        wirthdrawalconfigMapper.updateById(withdrawal);
        return new BaseVO();
    }
}
