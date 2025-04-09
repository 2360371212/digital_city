package org.digitalcity.action;

import org.digitalcity.service.IRecreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 娱乐健身控制层
 *
 * @author xupengxin
 * @date 2024/4/5
 */
@RestController
@RequestMapping("/digital_city/recreation/")
public class RecreationAction {
    @Autowired
    private IRecreationService recreationService;

    @RequestMapping("getByName")
    public Object getByName(String name) {
        return recreationService.selectByName(name);
    }
}
