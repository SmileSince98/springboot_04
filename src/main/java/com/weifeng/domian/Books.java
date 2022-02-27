package com.weifeng.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Books
 * @Description: TODO
 * @Author: 32051
 * @Date: 2022/2/26 16:10
 * @Version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {

    private Integer id;
    private String name;
    private String type;
    private String description;
}
