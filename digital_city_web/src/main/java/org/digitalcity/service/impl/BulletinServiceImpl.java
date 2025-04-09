package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.digitalcity.dao.IBulletinDAO;
import org.digitalcity.dao.entity.Bulletin;
import org.digitalcity.dto.resp.hospital.BulletinRespDTO;
import org.digitalcity.service.IBulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 医疗公告业务类
 */
@Service
public class BulletinServiceImpl implements IBulletinService {
    @Autowired
    public IBulletinDAO bulletinDAO;

    @Override
    public List<BulletinRespDTO> selectAll() {
        QueryWrapper<Bulletin> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "title", "output_date", "link");
        List<Bulletin> bulletins = bulletinDAO.selectList(queryWrapper);
        List<BulletinRespDTO> list = new ArrayList<>();
        bulletins.stream().forEach(bulletin -> {
            BulletinRespDTO bulletinRespDTO = new BulletinRespDTO(bulletin.getId(), bulletin.getTitle(), bulletin.getDate(), bulletin.getLink());
            list.add(bulletinRespDTO);
        });
        return list;
    }
}
