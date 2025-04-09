package org.digitalcity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.digitalcity.common.resp.RestResp;
import org.digitalcity.dao.ISiteDAO;
import org.digitalcity.dao.entity.Site;
import org.digitalcity.dto.resp.SiteRespDTO;
import org.digitalcity.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/6
 */
@Service
public class SiteServiceImpl implements ISiteService {

    @Autowired
    private ISiteDAO siteDAO;

    @Override
    public RestResp<SiteRespDTO> getByName(String name) {
        QueryWrapper<Site> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "content", "photo").eq("name", name);
        Site site = siteDAO.selectOne(queryWrapper);
        return RestResp.ok(new SiteRespDTO(site.getId(), site.getName(), site.getContent(), site.getPhoto()));
    }
}
