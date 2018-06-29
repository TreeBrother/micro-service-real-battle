package com.pdh.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: HelloWorldService</p>
 * <p>Description: 业务类处理断路器</p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: </p>
 *
 * @author denghao.peng
 * @version 1.0
 * @date 2018-06-20 14:29
 */
@Service
public class HelloWorldService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //observableExecutionMode.EAGER  同步方式      ObservableExecutionMode.LAZY   异步
    @HystrixCommand(fallbackMethod = "testFallback",observableExecutionMode = ObservableExecutionMode.EAGER)
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("MICROSERVICEREALBATTLEEUREKAPROVIDER");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        System.out.println(host + ": " + port );
        return restTemplate.getForEntity("http://MICROSERVICEREALBATTLEEUREKAPROVIDER/provider/test1",String.class).getBody();
    }

    public String testFallback(){
        return  "error";
    }
}
