package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通过shop id 查询店铺商品类别
     */
    List<ProductCategory> queryProductCategoryList(long shopId);

    /**
     * 批量新增商品类别
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

}
