package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.digitalcity.dao.IAttractionDAO;
import org.digitalcity.dao.entity.Attraction;
import org.digitalcity.dto.resp.AttractionRespDTO;
import org.digitalcity.service.IAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 景点信息业务类
 *
 * @author xupengxin
 * @date 2024/1/28
 */

@Service
public class AttractionServiceImpl implements IAttractionService {

    @Autowired
    private IAttractionDAO attractionDAO;

    public List<AttractionRespDTO> selectAll() {
        QueryWrapper<Attraction> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "content", "point", "flow", "cost");
        List<Attraction> attractions = attractionDAO.selectList(queryWrapper);
        List<AttractionRespDTO> list = new ArrayList<>();
        attractions.stream().forEach(attraction -> {
//            AttractionRespDTO target = AttractionRespDTO.builder()
//                    .id(attraction.getId())
//                    .name(attraction.getName())
//                    .content(attraction.getContent())
//                    .point(attraction.getPoint())
//                    .flow(attraction.getFlow())
//                    .cost(attraction.getCost())
//                    .build();
            AttractionRespDTO target = new AttractionRespDTO();
            target.setId(attraction.getId());
            target.setName(attraction.getName());
            target.setContent(attraction.getContent());
            target.setPoint(attraction.getPoint());
            target.setFlow(attraction.getFlow());
            target.setCost(attraction.getCost());
            list.add(target);
        });
        return list;
    }

    public AttractionRespDTO selectById(int id) {
        Attraction attraction = attractionDAO.selectById(id);
        AttractionRespDTO target = new AttractionRespDTO();
        target.setId(attraction.getId());
        target.setName(attraction.getName());
        target.setContent(attraction.getContent());
        target.setPoint(attraction.getPoint());
        target.setFlow(attraction.getFlow());
        target.setCost(attraction.getCost());
        return target;
    }

    public AttractionRespDTO selectByName(String name) {
        QueryWrapper<Attraction> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "content", "point", "flow", "cost").eq("name", name);
        Attraction attraction = attractionDAO.selectOne(queryWrapper);
//        return AttractionRespDTO.builder()
//                .id(attraction.getId())
//                .name(attraction.getName())
//                .content(attraction.getContent())
//                .point(attraction.getPoint())
//                .flow(attraction.getFlow())
//                .cost(attraction.getCost())
//                .build();
        AttractionRespDTO target = new AttractionRespDTO();
        target.setId(attraction.getId());
        target.setName(attraction.getName());
        target.setContent(attraction.getContent());
        target.setPoint(attraction.getPoint());
        target.setFlow(attraction.getFlow());
        target.setCost(attraction.getCost());
        return target;
    }
}
