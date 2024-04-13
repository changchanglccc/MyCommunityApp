package ca.lccc.myCommunityApp.service;

import ca.lccc.myCommunityApp.dto.ImageHolder;
import ca.lccc.myCommunityApp.dto.ProductExecution;
import ca.lccc.myCommunityApp.entity.Product;
import ca.lccc.myCommunityApp.exceptions.ProductOperationException;

import java.util.List;

public interface ProductService {
    /**
     * 添加商品信息以及图片处理(缩略图和详情图列表)
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
            throws ProductOperationException;
}
