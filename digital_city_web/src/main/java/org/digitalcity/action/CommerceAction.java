package org.digitalcity.action;

import org.digitalcity.service.ICommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/2
 */
@RestController
@RequestMapping("/digital_city/commerce/")
public class CommerceAction {
    @Autowired
    private ICommerceService commerceService;

    @GetMapping("getCommerce")
    public Object selectByName(String name) {
        return commerceService.selectByName(name);
    }
}
