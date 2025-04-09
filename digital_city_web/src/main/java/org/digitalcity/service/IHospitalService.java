package org.digitalcity.service;

import org.digitalcity.dto.resp.hospital.HospitalRespDTO;

import java.util.List;

public interface IHospitalService {
    public List<HospitalRespDTO> selectAll();
}
