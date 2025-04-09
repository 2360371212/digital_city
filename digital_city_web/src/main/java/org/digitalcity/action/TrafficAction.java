package org.digitalcity.action;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.resp.traffic.TrafficFlowRespDTO;

import org.digitalcity.service.ITrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/19
 */
@RestController
@RequestMapping("/digital_city/traffic/")
public class TrafficAction {
    @Autowired
    private ITrafficService trafficService;

    @GetMapping("/getFlow")
    public Object getFlowByName(String name) {
        return RestResp.ok(trafficService.getFlowByName(name));
    }

    @GetMapping("/getStationInf")
    public Object getStationInfByName(String name) {
        return trafficService.getStationByName(name);
    }

    /**
     * 根据场所名称获取用户评论(分页查找)
     *
     * @param name        场所名称
     * @param currentPage 当前查找页
     * @param pageSize    页面大小
     */
    @GetMapping("/getCommentByName")
    public Object getCommentByName(String name, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize) {
        return trafficService.selectCommentBatch(name, currentPage, pageSize);
    }
}
