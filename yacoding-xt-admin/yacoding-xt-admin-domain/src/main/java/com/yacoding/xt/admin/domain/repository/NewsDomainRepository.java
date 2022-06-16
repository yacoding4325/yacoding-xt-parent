package com.yacoding.xt.admin.domain.repository;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.yacoding.xt.admin.dao.AdminUserMapper;
import com.yacoding.xt.admin.dao.NewsMapper;
import com.yacoding.xt.admin.dao.data.AdminUser;
import com.yacoding.xt.admin.domain.AdminUserDomain;
import com.yacoding.xt.admin.domain.NewsDomain;
import com.yacoding.xt.admin.domain.qiniu.QiniuConfig;
import com.yacoding.xt.admin.params.AdminUserParam;
import com.yacoding.xt.admin.params.NewsParam;
import com.yacoding.xt.pojo.News;


import javax.annotation.Resource;

/**
 * @Author yaCoding
 * @create 2022-05-08 下午 9:13
 */
@Component
public class NewsDomainRepository {
    @Autowired
    public QiniuConfig qiniuConfig;
    @Resource
    private NewsMapper newsMapper;

    public NewsDomain createDomain(NewsParam newsParam) {
        return new NewsDomain(this,newsParam);
    }

    public Page<News> findNewsPageByCondition(int currentPage, int pageSize, String queryString) {
        Page<News> page = new Page<>(currentPage,pageSize);

        LambdaUpdateWrapper<News> queryWrapper = new LambdaUpdateWrapper<>();
        if (StringUtils.isNotBlank(queryString)){
            queryWrapper.like(News::getTitle,queryString);
        }
        return newsMapper.selectPage(page, queryWrapper);
    }

    public void save(News news) {
        this.newsMapper.insert(news);
    }

    public News findNewsById(Long id) {
        return newsMapper.selectById(id);
    }

    public void update(News news) {
        this.newsMapper.updateById(news);
    }
}
