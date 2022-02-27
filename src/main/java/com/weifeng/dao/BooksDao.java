package com.weifeng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weifeng.domian.Books;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName: BooksDao
 * @Description: TODO
 * @Author: 32051
 * @Date: 2022/2/26 16:12
 * @Version
 */
@Mapper
public interface BooksDao extends BaseMapper<Books> {
}
