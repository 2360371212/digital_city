package org.digitalcity.action;

import org.apache.ibatis.ognl.ASTProject;
import org.digitalcity.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 地点信息获取控制层
 *
 * @author xupengxin
 * @date 2024/4/6
 */
@RestController
@RequestMapping("/digital_city/site/")
public class SiteAction {
    @Autowired
    private ISiteService siteService;

    @RequestMapping("getByName")
    public Object getByName(String name) {
        return siteService.getByName(name);
    }
}
