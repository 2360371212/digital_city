package org.digitalcity.action;

import org.digitalcity.service.ILivelihoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/25
 */
@RestController()
@RequestMapping("/digital_city/livelihood/")
public class LivelihoodAction {
    @Autowired
    private ILivelihoodService livelihoodService;

    // 获取情感分数
    @GetMapping("score")
    public Object getAllEmotionScore() {
        return livelihoodService.getAllEmotionScore();
    }

    @GetMapping("getEmotionScoreBySource")
    public Object getEmotionsScoreBySource(String source) {
        return livelihoodService.getEmotionScoreBySource(source);
    }

    // 获取评论
    @GetMapping("getComment")
    public Object getCommentsByTag(String tag, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "15") int pageSize) {
        return livelihoodService.getCommentsByTag(tag, currentPage, pageSize);
    }
}
