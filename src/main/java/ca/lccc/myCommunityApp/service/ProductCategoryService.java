package ca.lccc.myCommunityApp.service;

import ca.lccc.myCommunityApp.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 查询指定某个店铺下的所有商品类别信息
     */
    List<ProductCategory> getProductCategoryList(long shopId);
}
