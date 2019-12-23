/**
 * 
 */
package com.project.transfurdfarms;

/**
 * @author Olabisi
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class AnimalConfiguration {
	@Bean(name = "messageSource")
	public  ReloadableResourceBundleMessageSource mesageSource() {
		ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
		messageBundle.setBasename("classpath:messages/messages");
		messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}
}
