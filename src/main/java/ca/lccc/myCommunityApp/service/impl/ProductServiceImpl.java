package ca.lccc.myCommunityApp.service.impl;

import ca.lccc.myCommunityApp.dao.ProductDao;
import ca.lccc.myCommunityApp.dao.ProductImgDao;
import ca.lccc.myCommunityApp.dto.ImageHolder;
import ca.lccc.myCommunityApp.dto.ProductExecution;
import ca.lccc.myCommunityApp.entity.Product;
import ca.lccc.myCommunityApp.entity.ProductImg;
import ca.lccc.myCommunityApp.enums.ProductStateEnum;
import ca.lccc.myCommunityApp.exceptions.ProductOperationException;
import ca.lccc.myCommunityApp.service.ProductService;
import ca.lccc.myCommunityApp.util.ImageUtil;
import ca.lccc.myCommunityApp.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductImgDao productImgDao;

    @Override
    @Transactional
    // 1.处理缩略图，获取缩略图相对路径并赋值给product
    // 2.往tb_product写入商品信息，获取productId
    // 3.结合productId批量处理商品详情图
    // 4.将商品详情图列表批量插入tb_product_img中
    public ProductExecution addProduct(Product product, ImageHolder thumbnail,
                                       List<ImageHolder> productImgHolderList) throws ProductOperationException {
        // 空值判断
        if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
            // 给商品设置上默认属性
            product.setCreateTime(new Date());
            product.setLastEditTime(new Date());
            // 默认为上架的状态
            product.setEnableStatus(1);
            // 若商品缩略图不为空则添加
            if (thumbnail != null) {
                addThumbnail(product, thumbnail);
            }
            try {
                // 创建商品信息
                int effectedNum = productDao.insertProduct(product);
                if (effectedNum <= 0) {
                    throw new ProductOperationException("failed to create product");
                }
            } catch (Exception e) {
                throw new ProductOperationException("failed to create product:" + e.toString());
            }
            // 若商品详情图不为空则添加
            if (productImgHolderList != null && productImgHolderList.size() > 0) {
                addProductImgList(product, productImgHolderList);
            }
            return new ProductExecution(ProductStateEnum.SUCCESS, product);
        } else {
            // 传参为空则返回空值错误信息
            return new ProductExecution(ProductStateEnum.EMPTY);
        }
    }

    /**
     * 添加缩略图
     * 把product当成参数传递（而不是把它设为class的属性），Service层一种解耦方式，让spring来协调管理属性
     */
    private void addThumbnail(Product product, ImageHolder thumbnail) {
        String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
        String thumbnailAddr = ImageUtil.generateThumbnail(thumbnail, dest);
        product.setImgAddr(thumbnailAddr);
    }

    /**
     * 批量添加图片
     */
    private void addProductImgList(Product product, List<ImageHolder> productImgHolderList) {
        // 获取图片存储路径，这里直接存放到相应店铺的文件夹底下
        String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        // 遍历图片一次去处理，并添加进productImg实体类里
        for (ImageHolder productImgHolder : productImgHolderList) {
            String imgAddr = ImageUtil.generateNormalImg(productImgHolder, dest);
            ProductImg productImg = new ProductImg();
            productImg.setImgAddr(imgAddr);
            productImg.setProductId(product.getProductId());
            productImg.setCreateTime(new Date());
            productImgList.add(productImg);
        }
        // 如果确实是有图片需要添加的，就执行批量添加操作
        if (productImgList.size() > 0) {
            try {
                int effectedNum = productImgDao.batchInsertProductImg(productImgList);
                if (effectedNum <= 0) {
                    throw new ProductOperationException("failed to create product image");
                }
            } catch (Exception e) {
                throw new ProductOperationException("failed to create product image:" + e.toString());
            }
        }
    }
}