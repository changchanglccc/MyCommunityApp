package ca.lccc.myCommunityApp.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shopadmin", method = { RequestMethod.GET })

/**
 * 主要用来解析路由并转发到相应的html中
 */
public class ShopAdminController {
    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        // 转发至店铺管理页面
        return "shop/shopmanagement";
    }

    @RequestMapping(value = "/shopoperation")
    public String shopOperation() {
        // spring-web.xml 中已经配置过对应的视图解析器
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList() {
        // 转发至店铺列表页面
        return "shop/shoplist";
    }

}

