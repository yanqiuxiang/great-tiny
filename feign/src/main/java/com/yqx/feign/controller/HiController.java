package com.yqx.feign.controller;

import com.yqx.feign.inte.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HiController {


	//编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
	@Autowired
	SchedualServiceHi schedualServiceHi;

	@GetMapping(value = "/hello")
	public String sayHi(@RequestParam String name) {
		return "[8083]"+schedualServiceHi.sayHiFromClientOne(name);
	}

}