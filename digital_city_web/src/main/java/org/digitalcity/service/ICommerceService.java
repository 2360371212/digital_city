package org.digitalcity.service;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.resp.CommerceRespDTO;

import java.util.List;

public interface ICommerceService {
    public RestResp<List<CommerceRespDTO>> selectByName(String name);
}
