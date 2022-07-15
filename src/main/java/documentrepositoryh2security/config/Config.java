package documentrepositoryh2security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class Config implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {

            registry.addResourceHandler("/files/**").addResourceLocations("file:files/");

        }
}

