/*
 * @Description: springboot入口
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-11-10 12:28:53
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-16 17:33:43
 */
package springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching
@EnableSwagger2
@SpringBootApplication
@MapperScan("springboot.mapper")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
