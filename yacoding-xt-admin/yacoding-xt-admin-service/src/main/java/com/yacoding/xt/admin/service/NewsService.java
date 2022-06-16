package com.yacoding.xt.admin.service;

import com.yacoding.xt.admin.params.NewsParam;
import com.yacoding.xt.common.model.CallResult;
import org.springframework.web.multipart.MultipartFile;

public interface NewsService {

    CallResult findPage(NewsParam newsParam);

    CallResult save(NewsParam newsParam);

    CallResult findNewsById(NewsParam newsParam);

    CallResult update(NewsParam newsParam);

    CallResult upload(MultipartFile file);
}
