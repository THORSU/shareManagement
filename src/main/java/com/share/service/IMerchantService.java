package com.share.service;

import com.share.pojo.Merchant;

/**
 * @author: QuincySu
 * @Date: 2018/5/21
 */
public interface IMerchantService {
    /**
     * 商家登录
     *
     * @param merchant
     * @return
     */
    public Merchant merchantLogin(Merchant merchant);
}
