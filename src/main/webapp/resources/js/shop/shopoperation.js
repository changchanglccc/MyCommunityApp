/**
 * Ajax + Jquery
 */
$(function() {
    // 用于店铺注册时候的店铺类别 以及 区域列表的 初始化的URL
    let initUrl = '/myCommunityApp/shopadmin/getshopinitinfo';
    // 注册店铺的URL
    let registerShopUrl = '/myCommunityApp/shopadmin/registershop';
    // alert(initUrl);
    getShopInitInfo();

    // 取得所有二级店铺类别以及区域信息，并分别赋值进类别列表以及区域列表
    function getShopInitInfo() {
        $.getJSON(initUrl, function(data) {
            if (data.success) {
                let tempHtml = '';
                let tempAreaHtml = '';
                data.shopCategoryList.map(function(item, index) {
                    tempHtml += '<option data-id="' + item.shopCategoryId
                        + '">' + item.shopCategoryName + '</option>';
                });
                data.areaList.map(function(item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">'
                        + item.areaName + '</option>';
                });
                $('#shop-category').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }
        });

        // 提交按钮的事件响应，分别对店铺注册和编辑操作做不同响应
        $('#submit').click(function() {
            // 创建shop对象
            let shop = {};
            if (isEdit) {
                // 若属于编辑，则给shopId赋值
                shop.shopId = shopId;
            }
            // 获取表单里的数据并填充进对应的店铺属性中
            shop.shopName = $('#shop-name').val();
            shop.shopAddr = $('#shop-addr').val();
            shop.phone = $('#shop-phone').val();
            shop.shopDesc = $('#shop-desc').val();
            // 选择选定好的店铺类别
            shop.shopCategory = {
                shopCategoryId : $('#shop-category').find('option').not(function() {
                    return !this.selected;
                }).data('id')
            };
            // 选择选定好的区域信息
            shop.area = {
                areaId : $('#area').find('option').not(function() {
                    return !this.selected;
                }).data('id')
            };
            // 获取上传的图片文件流
            let shopImg = $('#shop-img')[0].files[0];

            // 生成表单对象，用于接收参数并传递给后台
            let formData = new FormData();
            // 添加图片流进表单对象里
            formData.append('shopImg', shopImg);
            // 将shop json对象转成字符流保存至表单对象key为shopStr的的键值对里
            formData.append('shopStr', JSON.stringify(shop));

            // 获取表单里输入的验证码
            let verifyCodeActual = $('#j_captcha').val();
            if (!verifyCodeActual) {
                $.toast('pls input verifyCode！');
                return;
            }
            formData.append('verifyCodeActual', verifyCodeActual);

            // 将数据提交至后台处理相关操作
            $.ajax({
                url : (isEdit ? editShopUrl : registerShopUrl),
                type : 'POST',
                data : formData,
                contentType : false,
                processData : false,
                cache : false,
                success : function(data) {
                    if (data.success) {
                        $.toast('submit successfully！');
                    } else {
                        $.toast('failure to submit！' + data.errMsg);
                    }

                }
            });
        });
    }
})
