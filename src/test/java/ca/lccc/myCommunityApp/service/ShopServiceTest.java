package ca.lccc.myCommunityApp.service;

import ca.lccc.myCommunityApp.BaseTest;
import ca.lccc.myCommunityApp.service.ShopService;
import ca.lccc.myCommunityApp.dto.ImageHolder;
import ca.lccc.myCommunityApp.dto.ShopExecution;
import ca.lccc.myCommunityApp.entity.Area;
import ca.lccc.myCommunityApp.entity.PersonInfo;
import ca.lccc.myCommunityApp.entity.Shop;
import ca.lccc.myCommunityApp.entity.ShopCategory;
import ca.lccc.myCommunityApp.enums.ShopStateEnum;
import ca.lccc.myCommunityApp.exceptions.ShopOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws ShopOperationException, FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("test add shop ");
        shop.setShopDesc("test add shop desc");
        shop.setShopAddr("test add shop addr");
        shop.setPhone("test3");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("pending");
        File shopImg = new File("/Users/chongli/Desktop/image/logo.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder(shopImg.getName(), is);
        ShopExecution se = shopService.addShop(shop, imageHolder );
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }

}