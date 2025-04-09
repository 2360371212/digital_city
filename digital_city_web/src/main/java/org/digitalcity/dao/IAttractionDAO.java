package org.digitalcity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.digitalcity.dao.entity.Attraction;

@Mapper
public interface IAttractionDAO extends BaseMapper<Attraction> {
}
