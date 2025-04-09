package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dao.ITrafficCommentDAO;
import org.digitalcity.dao.ITrafficFlowDAO;
import org.digitalcity.dao.ITrafficStationDAO;
import org.digitalcity.dao.entity.TrafficComment;
import org.digitalcity.dao.entity.TrafficFlow;
import org.digitalcity.dao.entity.TrafficStation;
import org.digitalcity.dto.resp.traffic.TrafficCommentRespDTO;
import org.digitalcity.dto.resp.traffic.TrafficFlowRespDTO;

import org.digitalcity.dto.resp.traffic.TrafficStationRespDTO;
import org.digitalcity.service.ITrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 交通服务业务类
 *
 * @author xupengxin
 * @date 2024/3/19
 */
@Service
public class TrafficServiceImpl implements ITrafficService {
    @Autowired
    private ITrafficFlowDAO trafficFlowDAO;

    @Autowired
    private ITrafficStationDAO trafficStationDAO;

    @Autowired
    private ITrafficCommentDAO trafficCommentDAO;

    @Override
    public TrafficFlowRespDTO getFlowByName(String name) {
        QueryWrapper<TrafficFlow> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("year", "name", "flow").eq("name", name);
        List<TrafficFlow> trafficFlows = trafficFlowDAO.selectList(queryWrapper);
        TrafficFlowRespDTO trafficFlowRespDTO = new TrafficFlowRespDTO();
        Map<Integer, Float> map = new HashMap<>();
        float[] flow = new float[trafficFlows.size()];
        for (int i = 0; i < trafficFlows.size(); i++) {
            flow[i] = trafficFlows.get(i).getFlow();
        }
        trafficFlowRespDTO.setName(name);
        trafficFlowRespDTO.setFlow(flow);
        return trafficFlowRespDTO;
    }

    @Override
    public RestResp<TrafficStationRespDTO> getStationByName(String name) {
        QueryWrapper<TrafficStation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "content", "emotion_point").eq("name", name);
        TrafficStation trafficStation = trafficStationDAO.selectOne(queryWrapper);
        return RestResp.ok(new TrafficStationRespDTO(trafficStation.getId(), trafficStation.getName(), trafficStation.getContent(), trafficStation.getEmotionPoint()));
    }

    @Override
    public RestResp<List<TrafficCommentRespDTO>> selectCommentBatch(String name, int currentPage, int pageSize) {
        QueryWrapper<TrafficComment> wrapper = new QueryWrapper<>();
        wrapper.select("id", "name", "comment", "score").eq("name", name);
        IPage<TrafficComment> page1 = new Page<>(currentPage, pageSize, true);
        IPage<TrafficComment> result = trafficCommentDAO.selectPage(page1, wrapper);
        List<TrafficCommentRespDTO> list = new ArrayList<>();
        for (TrafficComment comment : result.getRecords()) {
            list.add(new TrafficCommentRespDTO(comment.getId(), comment.getName(), comment.getComment(), comment.getScore()));
        }
        return RestResp.ok(list);
    }


}
