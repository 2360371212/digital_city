package org.digitalcity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.digitalcity.dao.entity.TrafficComment;

/**
 * 用户交通评论DAO
 */
@Mapper
public interface ITrafficCommentDAO extends BaseMapper<TrafficComment> {
}
