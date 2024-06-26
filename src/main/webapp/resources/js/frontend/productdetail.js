$(function() {
    // 从地址栏的URL里获取productId
    let productId = getQueryString('productId');
    // 获取商品信息的URL
    let productUrl = '/myCommunityApp/frontend/listproductdetailpageinfo?productId='
        + productId;
    // 访问后台获取该商品的信息并渲染
    $.getJSON(productUrl, function(data) {
        if (data.success) {
            // 获取商品信息
            let product = data.product;
            // 给商品信息相关HTML控件赋值

            // 商品缩略图
            $('#product-img').attr('src', product.imgAddr);
            // 商品更新时间
            $('#product-time').text(new Date(product.lastEditTime).Format("yyyy-MM-dd"));
            if (product.point != undefined) {
                $('#product-point').text('you will get ' + product.point + 'point');
            }
            // 商品名称
            $('#product-name').text(product.productName);
            // 商品简介
            $('#product-desc').text(product.productDesc);
            // 商品价格展示逻辑，主要判断原价现价是否为空 ，所有都为空则不显示价格栏目
            if (product.normalPrice != undefined
                && product.promotionPrice != undefined) {
                // 如果现价和原价都不为空则都展示，并且给原价加个删除符号
                $('#price').show();
                $('#normalPrice').html(
                    '<del>' + '$' + product.normalPrice + '</del>');
                $('#promotionPrice').text('$' + product.promotionPrice);
            } else if (product.normalPrice != undefined
                && product.promotionPrice == undefined) {
                // 如果原价不为空而现价为空则只展示原价
                $('#price').show();
                $('#promotionPrice').text('$' + product.normalPrice);
            } else if (product.normalPrice == undefined
                && product.promotionPrice != undefined) {
                // 如果现价不为空而原价为空则只展示现价
                $('#promotionPrice').text('$' + product.promotionPrice);
            }
            let imgListHtml = '';
            // 遍历商品详情图列表，并生成批量img标签
            product.productImgList.map(function(item, index) {
                imgListHtml += '<div> <img src="' + item.imgAddr
                    + '" width="100%" /></div>';
            });
            // if (data.needQRCode) {
            // // 生成购买商品的二维码供商家扫描
            // imgListHtml += '<div> <img
            // src="/myCommunityApp/frontend/generateqrcode4product?productId='
            // + product.productId
            // + '" width="100%"/></div>';
            // }
            $('#imgList').html(imgListHtml);
        }
    });
    // 点击后打开右侧栏
    $('#me').click(function() {
        $.openPanel('#panel-right-demo');
    });

    $.init();
});
