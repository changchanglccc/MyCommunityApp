package ca.lccc.myCommunityApp.service;

import ca.lccc.myCommunityApp.dto.ProductCategoryExecution;
import ca.lccc.myCommunityApp.entity.ProductCategory;
import ca.lccc.myCommunityApp.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 查询指定某个店铺下的所有商品类别信息
     */
    List<ProductCategory> getProductCategoryList(long shopId);

    /**
     批量添加ProductCategory
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException;

    /**
     * 将此类别下的商品里的类别id置为null，再删除掉该商品类别
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
            throws ProductCategoryOperationException;

}
