package com.weifeng.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weifeng.domian.Books;
import com.weifeng.service.IBooksService;
import com.weifeng.utils.RESTFul_R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @ClassName: BooksController
 * @Description: TODO
 * @Author: 32051
 * @Date: 2022/2/26 16:16
 * @Version
 */
@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private IBooksService iBooksService;

    @GetMapping("{id}")
    public RESTFul_R getById(@PathVariable Integer id){
        return new RESTFul_R(true,iBooksService.getById(id));
    }

    @GetMapping
    public RESTFul_R getAll(){
        return new RESTFul_R(true,iBooksService.list());
    }

    @PostMapping
    public RESTFul_R save(@RequestBody Books books) throws IOException{
//        简化此操作，在风格类里面通过构造器实现初始化操作
//        RESTFul_R r = new RESTFul_R();
//        boolean save = iUserService.save(user);
//        r.setFlag(save);
//        r.setData(null);
//        return r;
        if (books.getName().equals(iBooksService.list())) throw new IOException();
        boolean save = iBooksService.save(books);
        return  new RESTFul_R(save,save ? "加载成功^-^":"加载失败-_-!");
    }
    @PutMapping
    public RESTFul_R update(@RequestBody Books books){
        return new RESTFul_R(iBooksService.updateById(books));
    }
    @DeleteMapping("{id}")
    public RESTFul_R delete(@PathVariable Integer id){
        return new RESTFul_R(true,iBooksService.removeById(id));
    }

//    @GetMapping("{currentPage}/{pageSizes}")
//    public RESTFul_R getPage(@PathVariable int currentPage,@PathVariable int pageSizes){
//        IPage<Books> page = iBooksService.getPage(currentPage, pageSizes);
//        //如果当前页码值大于总页码值，那么在执行分页查询操作时加载用页码值返回
//        if (currentPage > page.getPages()){
//            page = iBooksService.getPage((int) page.getPages(),pageSizes);
//        }
//        return new RESTFul_R(true,page);
//    }
//
    @GetMapping("{currentPage}/{pageSizes}")
    public RESTFul_R getPage(@PathVariable int currentPage,@PathVariable int pageSizes,Books books){
        IPage<Books> page = iBooksService.getPage(currentPage, pageSizes,books);
        //如果当前页码值大于总页码值，那么在执行分页查询操作时加载用页码值返回
        if (currentPage > page.getPages()){
            page = iBooksService.getPage((int) page.getPages(),pageSizes,books);
        }
        return new RESTFul_R(true,page);
    }
}
