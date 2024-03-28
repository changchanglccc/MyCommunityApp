package ca.lccc.myCommunityApp.service;

import ca.lccc.myCommunityApp.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    /**
     * 根据查询条件获取ShopCategory列表
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
