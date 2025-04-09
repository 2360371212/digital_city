package org.digitalcity.action;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.resp.hospital.BulletinRespDTO;
import org.digitalcity.dto.resp.hospital.HospitalRespDTO;
import org.digitalcity.service.IBulletinService;
import org.digitalcity.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/19
 */
@RestController
@RequestMapping("/digital_city/medical/")
public class MedicalAction {
    @Autowired
    private IHospitalService hospitalService;
    @Autowired
    private IBulletinService bulletinService;

    @GetMapping("getHospitals")
    public RestResp<List<HospitalRespDTO>> getAllHospital() {
        return RestResp.ok(hospitalService.selectAll());
    }

    @GetMapping("getBulletins")
    public RestResp<List<BulletinRespDTO>> getAllBulletin() {
        return RestResp.ok(bulletinService.selectAll());
    }
}
