package org.digitalcity.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/6
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteRespDTO {
    private int id;
    private String name;
    private String content;
    private String photo;
}
