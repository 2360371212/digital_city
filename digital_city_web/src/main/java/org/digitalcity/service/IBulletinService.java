package org.digitalcity.service;


import org.digitalcity.dto.resp.hospital.BulletinRespDTO;

import java.util.List;

public interface IBulletinService {
    public List<BulletinRespDTO> selectAll();
}
