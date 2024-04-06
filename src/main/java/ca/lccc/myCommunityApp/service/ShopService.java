package ca.lccc.myCommunityApp.service;

import ca.lccc.myCommunityApp.dto.ImageHolder;
import ca.lccc.myCommunityApp.dto.ShopExecution;
import ca.lccc.myCommunityApp.entity.Shop;
import ca.lccc.myCommunityApp.exceptions.ShopOperationException;

public interface ShopService {
    /**
     * 根据shopCondition分页返回相应店铺列表
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    /**
     * 通过店铺Id获取店铺信息
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息，包括对图片的处理
     */
    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

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
