package com.spring.configuration;

import com.spring.beans.ImportBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lhj
 * @date 2019/11/26 20:06
 */
@Import(ImportBean.class)
@ComponentScan("com.spring")
@Configuration
public class SpringAppConfig {




}
