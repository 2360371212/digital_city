package org.digitalcity.service;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.resp.old.PopulationStructureRespDTO;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/8
 */

public interface IPopulationStructureService {
    public RestResp<PopulationStructureRespDTO> getStructure();
}
