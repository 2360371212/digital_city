package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dao.IOldHomeDAO;
import org.digitalcity.dao.entity.OldHome;
import org.digitalcity.dto.resp.old.OldHomeRespDTO;
import org.digitalcity.service.IOldHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/5
 */
@Service
public class OldHomeServiceImpl implements IOldHomeService {

    @Autowired
    private IOldHomeDAO oldHomeDAO;

    @Override
    public RestResp<List<OldHomeRespDTO>> getAll() {
        QueryWrapper<OldHome> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "point", "content");
        List<OldHome> oldHomes = oldHomeDAO.selectList(queryWrapper);
        List<OldHomeRespDTO> list = new ArrayList<>();
        for (OldHome oldHome : oldHomes) {
            list.add(new OldHomeRespDTO(oldHome.getId(), oldHome.getName(), oldHome.getPoint(), oldHome.getContent()));
        }
        return RestResp.ok(list);
    }
}
