package ca.lccc.myCommunityApp.service;

import ca.lccc.myCommunityApp.dto.ImageHolder;
import ca.lccc.myCommunityApp.dto.ShopExecution;
import ca.lccc.myCommunityApp.entity.Shop;
import ca.lccc.myCommunityApp.exceptions.ShopOperationException;

public interface ShopService {
    /**
     *
     * 注册店铺信息，包括图片处理
     *
     * @param shop
     * @param thumbnail
     * @return
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
