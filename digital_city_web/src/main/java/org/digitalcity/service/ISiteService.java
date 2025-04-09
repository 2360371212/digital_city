package org.digitalcity.service;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.resp.SiteRespDTO;

public interface ISiteService {
    public RestResp<SiteRespDTO> getByName(String name);
}
