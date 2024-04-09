package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.BaseTest;
import ca.lccc.myCommunityApp.entity.ProductCategory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testProductCategoryDao() {
        Long shopId = 1L;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);

        System.out.println("product Categories in this shop：" + productCategoryList.size());
        assertEquals(10, productCategoryList.size());
    }
}
