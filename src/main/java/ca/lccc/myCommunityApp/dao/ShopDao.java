package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.entity.Shop;

public interface ShopDao {

    Shop queryByShopId(Long shopId);
    int insertShop(Shop shop);
    int updateShop(Shop shop);
}
