package com.yqx.feign.inte;


import com.yqx.feign.inte.fallback.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "nacos-server",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
