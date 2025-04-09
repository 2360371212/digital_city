package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dao.ICommentDAO;
import org.digitalcity.dao.IEmotionScoreDAO;
import org.digitalcity.dao.entity.Comment;
import org.digitalcity.dao.entity.EmotionScore;
import org.digitalcity.dto.resp.CommentRespDTO;
import org.digitalcity.dto.resp.EmotionScoreRespDTO;
import org.digitalcity.service.ILivelihoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 民生业务类
 *
 * @author xupengxin
 * @date 2024/3/25
 */
@Service
public class LivelihoodServiceImpl implements ILivelihoodService {

    @Autowired
    private IEmotionScoreDAO emotionScoreDAO;

    @Autowired
    private ICommentDAO commentDAO;

    @Override
    public RestResp<List<EmotionScoreRespDTO>> getAllEmotionScore() {
        QueryWrapper<EmotionScore> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "tag", "grades", "source");
        return getListRestResp(queryWrapper);
    }

    @Override
    public RestResp<List<EmotionScoreRespDTO>> getEmotionScoreBySource(String source) {
        QueryWrapper<EmotionScore> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "tag", "grades", "source").eq("source", source);
        return getListRestResp(queryWrapper);
    }

    private RestResp<List<EmotionScoreRespDTO>> getListRestResp(QueryWrapper<EmotionScore> queryWrapper) {
        List<EmotionScore> emotionScores = emotionScoreDAO.selectList(queryWrapper);
        List<EmotionScoreRespDTO> list = new ArrayList<>();
        for (EmotionScore emotionScore : emotionScores) {
            list.add(new EmotionScoreRespDTO(emotionScore.getId(),
                    emotionScore.getTag(), emotionScore.getGrades(), emotionScore.getSource()));
        }
        return RestResp.ok(list);
    }

    @Override
    public RestResp<CommentRespDTO> getCommentsByTag(String tag, int currentPage, int pageSize) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("content").eq("tag", tag);
        IPage<Comment> page = new Page<>(currentPage, pageSize, true);
        IPage<Comment> result = commentDAO.selectPage(page, queryWrapper);
        List<String> list = result.getRecords().stream().map(Comment::getContent).toList();
        CommentRespDTO commentRespDTO = new CommentRespDTO();
        commentRespDTO.setTag(tag);
        commentRespDTO.setContents(list);
        return RestResp.ok(commentRespDTO);
    }
}
