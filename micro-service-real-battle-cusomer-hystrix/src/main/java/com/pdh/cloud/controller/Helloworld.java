package com.pdh.cloud.controller;

import com.pdh.cloud.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private HelloWorldService helloWorldService;




    @GetMapping("/consumer/test")
    public String test(){
      return  this.helloWorldService.test();
    }

}
