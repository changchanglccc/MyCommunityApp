package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.entity.ProductImg;

import java.util.List;

public interface ProductImgDao {

    /**
     * 列出某个商品的详情图列表
     */
    List<ProductImg> queryProductImgList(long productId);

    /**
     * 批量添加商品详情pics
     */
    int batchInsertProductImg(List<ProductImg> productImgList);

    /**
     * 删除指定商品下的所有详情图
     */
    int deleteProductImgByProductId(long productId);
}
