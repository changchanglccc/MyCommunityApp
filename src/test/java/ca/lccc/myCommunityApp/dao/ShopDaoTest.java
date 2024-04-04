package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.BaseTest;
import ca.lccc.myCommunityApp.entity.Area;
import ca.lccc.myCommunityApp.entity.PersonInfo;
import ca.lccc.myCommunityApp.entity.Shop;
import ca.lccc.myCommunityApp.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryByShopId() {
        long shopId = 1L;
        Shop shop = shopDao.queryByShopId(shopId);
        assertEquals("montreal", shop.getArea().getAreaName());
        assertEquals("Computer", shop.getShopCategory().getShopCategoryName());
    }

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        PersonInfo owner = new PersonInfo();
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        owner.setUserId(1L);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setOwner(owner);
        shop.setShopName("test-shop");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(0);
        shop.setAdvice("pending");

        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(84L);
        shop.setShopDesc("test-ddd");
        shop.setShopAddr("test-aaa");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
    }
}
