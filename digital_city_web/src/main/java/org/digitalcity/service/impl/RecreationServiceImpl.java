package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dao.IRecreationDAO;
import org.digitalcity.dao.entity.Recreation;
import org.digitalcity.dto.resp.RecreationRespDTO;
import org.digitalcity.service.IRecreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 娱乐建身服务
 *
 * @author xupengxin
 * @date 2024/4/5
 */
@Service
public class RecreationServiceImpl implements IRecreationService {

    @Autowired
    private IRecreationDAO recreationDAO;

    @Override
    public RestResp<List<RecreationRespDTO>> selectByName(String name) {
        QueryWrapper<Recreation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "tag", "point").eq("name", name);
        List<Recreation> recreations = recreationDAO.selectList(queryWrapper);
        List<RecreationRespDTO> list = new ArrayList<>();
        for (Recreation recreation : recreations) {
            list.add(new RecreationRespDTO(recreation.getId(), recreation.getName(), recreation.getTag(), recreation.getPoint()));
        }
        return RestResp.ok(list);
    }
}
