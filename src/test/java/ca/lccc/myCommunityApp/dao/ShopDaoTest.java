package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.BaseTest;
import ca.lccc.myCommunityApp.entity.Area;
import ca.lccc.myCommunityApp.entity.PersonInfo;
import ca.lccc.myCommunityApp.entity.Shop;
import ca.lccc.myCommunityApp.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryShopListAndCount() {
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
//		ShopCategory childCategory = new ShopCategory();
//		ShopCategory parentCategory = new ShopCategory();
//		parentCategory.setShopCategoryId(1L);
//		childCategory.setParent(parentCategory);
//		shopCondition.setShopCategory(childCategory);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 6);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("shop list size ：" + shopList.size());
        System.out.println("shop count ：" + count);
    }

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
