package org.digitalcity.service;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.resp.old.OldHomeRespDTO;

import java.util.List;

public interface IOldHomeService {
    public RestResp<List<OldHomeRespDTO>> getAll();
}
