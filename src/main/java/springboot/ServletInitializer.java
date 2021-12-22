/*
 * @Description: file description
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-11-10 12:28:53
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-12 14:22:34
 */
package springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainApplication.class);
	}

}
