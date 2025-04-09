package org.digitalcity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.digitalcity.dao.entity.TrafficFlow;

@Mapper
public interface ITrafficFlowDAO extends BaseMapper<TrafficFlow> {
}
