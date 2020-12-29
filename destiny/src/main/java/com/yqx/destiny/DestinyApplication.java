package com.yqx.destiny;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class DestinyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DestinyApplication.class, args);
	}

	@Slf4j
	@RestController
	@Api("测试用例1")
	static class TestController {

		@GetMapping("/hello")
		@ApiOperation(value = "apiOperationSwaggerTest", notes = "apiOperationSwagger测试")
		@ApiImplicitParams({@ApiImplicitParam(name = "id", value = "id入参", required = true, dataType = "Integer", paramType = "query"),
				@ApiImplicitParam(name = "brand", value = "brand", required = true, dataType = "BRAND", paramType = "body")
		})
		public String hello(String name) {
			log.info("name:{}", name);
			return "hello " + name;
		}
	}
}
