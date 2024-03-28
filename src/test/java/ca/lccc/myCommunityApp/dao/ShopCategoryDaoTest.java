package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.BaseTest;
import ca.lccc.myCommunityApp.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void ShopCategoryDaoTest() {
        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(null);
        assertEquals(8, shopCategories.size());
    }
}
