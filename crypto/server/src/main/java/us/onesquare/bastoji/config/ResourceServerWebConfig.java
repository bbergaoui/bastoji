package us.onesquare.bastoji.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({ "us.onesquare.bastoji" })
public class ResourceServerWebConfig extends WebMvcConfigurerAdapter {
    //
}
