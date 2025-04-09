package org.digitalcity.dto.resp.hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/3/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulletinRespDTO {
    private int id;
    private String title;
    private String date;
    private String link;
}
