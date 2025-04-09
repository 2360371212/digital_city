package org.digitalcity.service;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.resp.RecreationRespDTO;

import java.util.List;

public interface IRecreationService {
    public RestResp<List<RecreationRespDTO>> selectByName(String name);
}
