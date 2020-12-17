package com.yqx.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClientApplication.class, args);
	}


	@Slf4j
	@RestController
	static class TestController{

		@Autowired
		LoadBalancerClient loadBalancerClient;

		/**
		 * 方法名：
		 * 功能：通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
		 * 描述：
		 * 创建人：typ
		 * 创建时间：2019/1/21 10:54
		 * 修改人：
		 * 修改描述：
		 * 修改时间：
		 */
		@GetMapping("/test")
		public String test(){
			ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-server");
			String url = serviceInstance.getUri() + "/hello?name=" + "zhangsan";
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			return "Invoke : " + url + ", return : " + result;
		}
	}
}
