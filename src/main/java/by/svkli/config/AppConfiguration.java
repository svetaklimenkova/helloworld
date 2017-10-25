package by.svkli.config;

import by.svkli.lang.Language;
import by.svkli.lang.impl.Vietnamese;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"by.svkli.bean"})
public class AppConfiguration {

    @Bean(name ="language")
    public Language getLanguage() {

        return new Vietnamese();
    }

}
