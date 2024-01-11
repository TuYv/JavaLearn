package com.rick.springcloud.annotation.scope;

import com.rick.springcloud.dto.DemoDTO;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * @author Rick.Tu
 * @program JavaLearn
 * @description
 * @create 2024-01-10 23:21
 **/
@Service
//
public class ScopedService {
    @Bean
    //@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DemoDTO user() {
        return new DemoDTO("Rick.Tu", ThreadLocalRandom.current().nextInt());
    }
}
