package org.digitalcity.action;

import org.digitalcity.service.ILifeCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/7
 */
@RestController
@RequestMapping("/digital_city/lifeCircle/")
public class LifeCircleAction {
    @Autowired
    private ILifeCircleService lifeCircleService;

    @RequestMapping("getInfByName")
    public Object getInfByName(String name) {
        return lifeCircleService.getInfByName(name);
    }
}
