package org.digitalcity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.digitalcity.dao.entity.Bulletin;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/19
 */
@Mapper
public interface IBulletinDAO extends BaseMapper<Bulletin> {
}
