package com.yacoding.xt.admin.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yacoding.xt.admin.domain.repository.NewsDomainRepository;
import com.yacoding.xt.admin.model.NewsModel;
import com.yacoding.xt.admin.params.NewsParam;
import com.yacoding.xt.common.enums.Status;
import com.yacoding.xt.common.model.CallResult;
import com.yacoding.xt.common.model.ListPageModel;
import com.yacoding.xt.pojo.News;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;
import com.yacoding.xt.common.utils.QiniuUtils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author yaCoding
 * @create 2022-05-08 下午 7:00
 */

public class NewsDomain {

    private NewsDomainRepository newsDomainRepository;
    private NewsParam newsParam;

    public NewsDomain(NewsDomainRepository newsDomainRepository, NewsParam newsParam) {
        this.newsDomainRepository = newsDomainRepository;
        this.newsParam = newsParam;
    }

    public NewsModel copy(News news){
        if (news == null){
            return null;
        }
        NewsModel newsModel = new NewsModel();
        //属性copy
        BeanUtils.copyProperties(news,newsModel);
        if (news.getCreateTime() != null) {
            newsModel.setCreateTime(new DateTime(news.getCreateTime()).toString("yyyy年MM月dd日 HH:mm:ss"));
        }
        if (news.getImageUrl() != null) {
            if (!news.getImageUrl().startsWith("http")) {
                newsModel.setImageUrl(newsDomainRepository.qiniuConfig.getFileServerUrl() + news.getImageUrl());
            }
        }
        return newsModel;
    }

    public List<NewsModel> copyList(List<News> newsList){
        List<NewsModel> newsModelList = new ArrayList<>();
        for (News news : newsList){
            newsModelList.add(copy(news));
        }
        return newsModelList;
    }

    public CallResult<Object> findNewsPage() {
        int currentPage = this.newsParam.getCurrentPage();
        int pageSize = this.newsParam.getPageSize();
        String queryString = this.newsParam.getQueryString();
        Page<News> newsPage = newsDomainRepository.findNewsPageByCondition(currentPage,pageSize,queryString);

        ListPageModel<NewsModel> listPageModel = new ListPageModel<>();
        List<News> records = newsPage.getRecords();
        List<NewsModel> newsModelList = copyList(records);
        listPageModel.setList(newsModelList);
        listPageModel.setSize(newsPage.getTotal());
        return CallResult.success(listPageModel);
    }

    public CallResult<Object> save() {
        News news = new News();
        BeanUtils.copyProperties(this.newsParam,news);
        news.setCreateTime(System.currentTimeMillis());
        news.setStatus(Status.NORMAL.getCode());
        this.newsDomainRepository.save(news);
        return CallResult.success();
    }

    public CallResult<Object> findNewsById() {
        News news = this.newsDomainRepository.findNewsById(this.newsParam.getId());
        return CallResult.success(news);
    }

    public CallResult<Object> update() {
        News news = new News();
        BeanUtils.copyProperties(this.newsParam,news);
        this.newsDomainRepository.update(news);
        return CallResult.success();
    }

    public CallResult upload(MultipartFile file) {
        String accessKey = this.newsDomainRepository.qiniuConfig.getAccessKey();
        String accessSecret = this.newsDomainRepository.qiniuConfig.getAccessSecret();
        String bucket = this.newsDomainRepository.qiniuConfig.getBucket();
        //aa.jpg
        String originalFilename = file.getOriginalFilename();
        //yyyy-MM-dd
        DateTime dateTime = new DateTime();
        String fileName = "xt/news/"
                +dateTime.toString("yyyy")+"/"
                + dateTime.toString("MM")+"/"
                + UUID.randomUUID().toString()+"."
                + StringUtils.substringAfterLast(originalFilename,".");
        try {
            boolean upload = QiniuUtils.upload(accessKey, accessSecret, bucket, file.getBytes(), fileName);
            if (upload){
                return CallResult.success(this.newsDomainRepository.qiniuConfig.getFileServerUrl()+fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CallResult.fail(-999,"图片上传失败");
    }
}