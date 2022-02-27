package com.weifeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weifeng.dao.BooksDao;
import com.weifeng.domian.Books;
import com.weifeng.service.IBooksService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BooksServiceImpl
 * @Description: TODO
 * @Author: 32051
 * @Date: 2022/2/26 16:14
 * @Version
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksDao, Books> implements IBooksService {

    @Autowired
    private BooksDao booksDao;

    @Override
    public IPage<Books> getPage(int currentPage, int pageSizes) {
        Page<Books> page = new Page<>(currentPage, pageSizes);
        booksDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Books> getPage(int currentPage, int pageSizes, Books books) {
        LambdaQueryWrapper<Books> lambdaQueryWrapper = new LambdaQueryWrapper<Books>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(books.getType()),Books::getType,books.getType());
        lambdaQueryWrapper.like(Strings.isNotEmpty(books.getName()),Books::getName,books.getName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(books.getDescription()),Books::getDescription,books.getDescription());
        Page<Books> page = new Page<>(currentPage, pageSizes);
        booksDao.selectPage(page,lambdaQueryWrapper);
        return page;
    }
}
