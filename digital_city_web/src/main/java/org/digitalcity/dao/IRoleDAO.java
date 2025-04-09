package org.digitalcity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.digitalcity.dao.entity.Role;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/22
 */
@Mapper
public interface IRoleDAO extends BaseMapper<Role> {
}
