package ca.lccc.myCommunityApp.service.impl;

import ca.lccc.myCommunityApp.dao.ShopCategoryDao;
import ca.lccc.myCommunityApp.entity.ShopCategory;
import ca.lccc.myCommunityApp.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
