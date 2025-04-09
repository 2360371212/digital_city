package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.digitalcity.dao.IHospitalDAO;
import org.digitalcity.dao.entity.Hospital;
import org.digitalcity.dto.resp.hospital.HospitalRespDTO;
import org.digitalcity.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 医疗服务业务类
 *
 * @author xupengxin
 * @date 2024/3/19
 */
@Service
public class HospitalServiceImpl implements IHospitalService {
    @Autowired
    private IHospitalDAO hospitalDAO;

    @Override
    public List<HospitalRespDTO> selectAll() {
        QueryWrapper<Hospital> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "tag", "point", "link");
        List<Hospital> hospitals = hospitalDAO.selectList(queryWrapper);
        List<HospitalRespDTO> list = new ArrayList<>();
        hospitals.stream().forEach(hospital -> {
            HospitalRespDTO hospitalRespDTO = new HospitalRespDTO(hospital.getId(), hospital.getName(), hospital.getTag(), hospital.getPoint(), hospital.getLink());
            list.add(hospitalRespDTO);
        });
        return list;
    }
}
