package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dao.ICircleInfDAO;
import org.digitalcity.dao.entity.CircleInf;
import org.digitalcity.service.ILifeCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/7
 */
@Service
public class LifeCircleServiceImpl implements ILifeCircleService {
    @Autowired
    private ICircleInfDAO circleInfDAO;

    /**
     * 根据社区名称获取数目信息
     *
     * @param name 社区名称
     * @return
     */
    @Override
    public RestResp<CircleInf> getInfByName(String name) {
        QueryWrapper<CircleInf> wrapper = new QueryWrapper<>();
        wrapper.select("id", "name", "school", "convenience_store", "supermarket", "vegetable_market", "hospital", "drugstore", "bank",
                "community", "scenic_plot", "parking_lot", "wc",
                "police").eq("name", name);
        CircleInf circleInf = circleInfDAO.selectOne(wrapper);
        return RestResp.ok(circleInf);
    }

}
