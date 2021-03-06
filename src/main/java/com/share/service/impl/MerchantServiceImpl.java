package com.share.service.impl;

import com.share.mapper.MerchantMapper;
import com.share.pojo.Merchant;
import com.share.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: QuincySu
 * @Date: 2018/5/21
 */
@Service
public class MerchantServiceImpl implements IMerchantService {
    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Merchant merchantLogin(Merchant merchant) {
        return merchantMapper.merchantLogin(merchant);
    }

    @Override
    public int merchantSignUp(Merchant merchant) {
        return merchantMapper.merchantSignUp(merchant);
    }

    @Override
    public Merchant getMerchant(Merchant merchant) {
        return merchantMapper.getMerchant(merchant);
    }
}
