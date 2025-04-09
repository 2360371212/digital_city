package org.digitalcity.action;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.resp.AttractionRespDTO;
import org.digitalcity.service.IAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/28
 */
@RestController
@RequestMapping("/digital_city/attraction/")
public class AttractionAction {
    @Autowired
    private IAttractionService attractionService;

    @GetMapping("/get/{id}")
    public RestResp<AttractionRespDTO> get(@PathVariable(name = "id") int id) {
        return RestResp.ok(attractionService.selectById(id));
    }

    @GetMapping("/getAll")
    public RestResp<List<AttractionRespDTO>> getAll() {
        return RestResp.ok(attractionService.selectAll());
    }

    @GetMapping("/getByName")
    public RestResp<AttractionRespDTO> getByName(String name) {
        return RestResp.ok(attractionService.selectByName(name));
    }
}
