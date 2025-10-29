package com.example.KTB_7WEEK.swagger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = false)
public class AppConfig {

}
