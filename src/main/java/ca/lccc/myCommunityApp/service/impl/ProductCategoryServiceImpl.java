package ca.lccc.myCommunityApp.service.impl;

import ca.lccc.myCommunityApp.dao.ProductCategoryDao;
import ca.lccc.myCommunityApp.dao.ShopCategoryDao;
import ca.lccc.myCommunityApp.entity.ProductCategory;
import ca.lccc.myCommunityApp.entity.ShopCategory;
import ca.lccc.myCommunityApp.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }
}
