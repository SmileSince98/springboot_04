package com.weifeng.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weifeng.domian.Books;

/**
 * @InterfaceName: IBooksService
 * @Description: TODO
 * @Author: 32051
 * @Date: 2022/2/26 16:13
 * @Version
 */
public interface IBooksService extends IService<Books> {

    IPage<Books> getPage(int currentPage,int pageSizes);

    IPage<Books> getPage(int currentPage,int pageSizes,Books books);
}
