package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dao.IPopulationStructureDAO;
import org.digitalcity.dao.entity.PopulationStructure;
import org.digitalcity.dto.resp.old.PopulationStructureRespDTO;
import org.digitalcity.service.IPopulationStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 查询人口结构
 *
 * @author xupengxin
 * @date 2024/4/8
 */
@Service
public class PopulationStructureServiceImpl implements IPopulationStructureService {
    @Autowired
    private IPopulationStructureDAO populationStructureDAO;

    @Override
    public RestResp<PopulationStructureRespDTO> getStructure() {
        // 查询年龄范围
        QueryWrapper<PopulationStructure> wrapperScope = new QueryWrapper<>();
        wrapperScope.select("scope");
        List<PopulationStructure> scopeList = populationStructureDAO.selectList(wrapperScope);
        List<String> listScope = scopeList.stream().map(PopulationStructure::getScope).toList();
        // 查询男性人口结构
        QueryWrapper<PopulationStructure> wrapperMale = new QueryWrapper<>();
        wrapperMale.select("male");
        List<PopulationStructure> maleList = populationStructureDAO.selectList(wrapperMale);
        List<Integer> listMale = maleList.stream().map(PopulationStructure::getMale).toList();
        // 查询女性人口结构
        QueryWrapper<PopulationStructure> wrapperFemale = new QueryWrapper<>();
        List<PopulationStructure> femaleList = populationStructureDAO.selectList(wrapperFemale);
        List<Integer> listFemale = femaleList.stream().map(PopulationStructure::getFemale).toList();

        return RestResp.ok(new PopulationStructureRespDTO(listScope, listMale, listFemale));
    }
}
