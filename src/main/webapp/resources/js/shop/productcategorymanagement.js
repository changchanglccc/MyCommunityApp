$(function () {

    let listUrl = '/myCommunityApp/shopadmin/getproductcategorylist';
    let addUrl = '/myCommunityApp/shopadmin/addproductcategorys';
    let deleteUrl = '/myCommunityApp/shopadmin/removeproductcategory';

    getList();

    function getList() {
        $.getJSON(
            listUrl,
            function (data) {
                if (data.success) {
                    let dataList = data.data;
                    $('.category-wrap').html('');
                    let tempHtml = '';
                    dataList
                        .map(function (item, index) {
                            tempHtml += ''
                                + '<div class="row row-product-category now">'
                                + '<div class="col-33 product-category-name">'
                                + item.productCategoryName
                                + '</div>'
                                + '<div class="col-33">'
                                + item.priority
                                + '</div>'
                                + '<div class="col-33"><a href="#" class="button delete" data-id="'
                                + item.productCategoryId
                                + '">del</a></div>'
                                + '</div>';
                        });
                    $('.category-wrap').append(tempHtml);
                }
            });
    }

    $('#new')
        .click(
            function () {
                let tempHtml = '<div class="row row-product-category temp">'
                    + '<div class="col-33"><input class="category-input category" type="text" placeholder="product category name"></div>'
                    + '<div class="col-33"><input class="category-input priority" type="number" placeholder="priority"></div>'
                    + '<div class="col-33"><a href="#" class="button delete">del</a></div>'
                    + '</div>';
                $('.category-wrap').append(tempHtml);
            });

    $('#submit').click(function () {
        let tempArr = $('.temp');
        let productCategoryList = [];
        tempArr.map(function (index, item) {
            let tempObj = {};
            tempObj.productCategoryName = $(item).find('.category').val();
            tempObj.priority = $(item).find('.priority').val();
            if (tempObj.productCategoryName && tempObj.priority) {
                productCategoryList.push(tempObj);
            }
        });
        $.ajax({
            url: addUrl,
            type: 'POST',
            data: JSON.stringify(productCategoryList),
            contentType: 'application/json',
            success: function (data) {
                if (data.success) {
                    $.toast('submitted successfully！');
                    getList();
                } else {
                    $.toast('failure to submit！');
                }
            }
        });
    });

    //temp 表示新增的（未落库，若要删除，直接在前端删除）
    $('.category-wrap').on('click', '.row-product-category.temp .delete',
        function (e) {
            console.log($(this).parent().parent());
            $(this).parent().parent().remove();

        });

    // now表示已经添加的 (已落库，若要删除，要在后端删除)
    $('.category-wrap').on('click', '.row-product-category.now .delete',
        function (e) {
            let target = e.currentTarget;
            $.confirm('Yes?', function () {
                $.ajax({
                    url: deleteUrl,
                    type: 'POST',
                    data: {
                        productCategoryId: target.dataset.id
                    },
                    dataType: 'json',
                    success: function (data) {
                        if (data.success) {
                            $.toast('delete successfully！');
                            getList();
                        } else {
                            $.toast('failure to delete！');
                        }
                    }
                });
            });
        });
});
