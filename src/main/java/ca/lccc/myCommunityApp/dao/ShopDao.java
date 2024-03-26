package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.entity.Shop;

public interface ShopDao {
    int insertShop(Shop shop);
    int updateShop(Shop shop);
}
