package com.weifeng.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: RESTFul_R 进行格式统一操作
 * @Description: TODO
 * @Author: 32051
 * @Date: 2022/2/26 13:14
 * @Version
 */
@Data
@NoArgsConstructor
public class RESTFul_R {

    private Boolean flag;
    private Object data;
    private String message;

    public RESTFul_R(Boolean flag){
        this.flag = flag;
    }
    public RESTFul_R(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
    public RESTFul_R(String message){
        this.flag = false;
        this.message = message;
    }
    public RESTFul_R(Boolean flag,String message){
        this.flag = flag;
        this.message = message;
    }

}
