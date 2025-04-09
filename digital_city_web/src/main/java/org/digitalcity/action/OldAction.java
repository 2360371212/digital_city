package org.digitalcity.action;

import org.digitalcity.service.IOldHomeService;
import org.digitalcity.service.IPopulationStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/5
 */
@RestController
@RequestMapping("/digital_city/old/")
public class OldAction {
    @Autowired
    private IOldHomeService oldHomeService;

    @Autowired
    private IPopulationStructureService populationStructureService;

    @RequestMapping("rank")
    public Object getAll() {
        return oldHomeService.getAll();
    }

    @RequestMapping("getPopulation")
    public Object getPopulation() {
        return populationStructureService.getStructure();
    }
}
