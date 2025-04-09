package org.digitalcity.service;

import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dao.entity.CircleInf;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/7
 */
public interface ILifeCircleService {
    public RestResp<CircleInf> getInfByName(String name);

}
