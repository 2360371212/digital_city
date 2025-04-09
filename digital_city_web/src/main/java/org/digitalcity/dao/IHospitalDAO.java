package org.digitalcity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.digitalcity.dao.entity.Hospital;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/19
 */
@Mapper
public interface IHospitalDAO extends BaseMapper<Hospital> {
}
