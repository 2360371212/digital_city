package org.digitalcity.service;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.resp.traffic.TrafficCommentRespDTO;
import org.digitalcity.dto.resp.traffic.TrafficFlowRespDTO;
import org.digitalcity.dto.resp.traffic.TrafficStationRespDTO;

import java.util.List;


public interface ITrafficService {
    public TrafficFlowRespDTO getFlowByName(String name);

    public RestResp<TrafficStationRespDTO> getStationByName(String name);

    public RestResp<List<TrafficCommentRespDTO>> selectCommentBatch(String name, int currentPage, int pageSize);
}
