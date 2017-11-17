package pwr.kgl.taskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class TaskApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApiApplication.class, args);
    }

    @Configuration
    public class AppConfig
    {
        @Bean
        @ConfigurationProperties(prefix = "custom.rest.connection")
        public HttpComponentsClientHttpRequestFactory customHttpRequestFactory()
        {
            return new HttpComponentsClientHttpRequestFactory();
        }

        @Bean
        public RestTemplate customRestTemplate()
        {
            return new RestTemplate(customHttpRequestFactory());
        }
    }
}
