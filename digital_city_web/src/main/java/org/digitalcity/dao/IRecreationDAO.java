package org.digitalcity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.digitalcity.dao.entity.Recreation;

@Mapper
public interface IRecreationDAO extends BaseMapper<Recreation> {
}
