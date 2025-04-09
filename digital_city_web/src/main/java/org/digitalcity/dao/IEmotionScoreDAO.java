package org.digitalcity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.digitalcity.dao.entity.EmotionScore;

@Mapper
public interface IEmotionScoreDAO extends BaseMapper<EmotionScore> {

}
