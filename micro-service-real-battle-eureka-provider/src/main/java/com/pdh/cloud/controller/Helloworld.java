package com.pdh.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: Helloworld </p>
 * <p>Description: spring cloud 服务者</p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: </p>
 *
 * @author denghao.peng
 * @version 1.0
 * @date 2018-06-12 11:04
 */
@RestController
public class Helloworld {


    @GetMapping(value = "/provider/test1",produces = "application/json")
    public Map<String,Object> test(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("name","张三");
        resultMap.put("age",12);
        System.out.println(" resultMap:"+ resultMap.toString() );
        return resultMap;
    }

}
