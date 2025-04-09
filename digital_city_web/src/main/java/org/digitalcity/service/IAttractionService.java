package org.digitalcity.service;


import org.digitalcity.dao.entity.Attraction;
import org.digitalcity.dto.resp.AttractionRespDTO;

import java.util.List;

public interface IAttractionService {
    public List<AttractionRespDTO> selectAll();

    public AttractionRespDTO selectById(int id);

    public AttractionRespDTO selectByName(String name);
}
