package org.digitalcity.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRespDTO {
    private String tag;
    private List<String> contents;
}
