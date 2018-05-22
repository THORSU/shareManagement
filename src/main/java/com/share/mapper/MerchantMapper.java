package com.share.mapper;

import com.share.pojo.Merchant;

/**
 * @author: QuincySu
 * @Date: 2018/5/21
 */
public interface MerchantMapper {
    /**
     * 商家登录
     *
     * @param merchant
     * @return
     */
    public Merchant merchantLogin(Merchant merchant);

    /**
     * 商家注册
     *
     * @param merchant
     * @return
     */
    public int merchantSignUp(Merchant merchant);
}
