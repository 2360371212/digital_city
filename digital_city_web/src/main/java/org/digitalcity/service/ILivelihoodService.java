package org.digitalcity.service;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dto.resp.CommentRespDTO;
import org.digitalcity.dto.resp.EmotionScoreRespDTO;

import java.util.List;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/25
 */
public interface ILivelihoodService {
    public RestResp<List<EmotionScoreRespDTO>> getAllEmotionScore();

    public RestResp<List<EmotionScoreRespDTO>> getEmotionScoreBySource(String source);

    public RestResp<CommentRespDTO> getCommentsByTag(String tag, int currentPage, int pageSize);
}
