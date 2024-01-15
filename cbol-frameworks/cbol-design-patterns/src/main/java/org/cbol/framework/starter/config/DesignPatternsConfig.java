package org.cbol.framework.starter.config;

import org.cbol.framework.starter.chain.AbstractChainContext;
import org.cbol.framework.starter.web.config.WebAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author yaowenlei
 * @date 2024年01月15日 2:04 下午
 */
@ImportAutoConfiguration({WebAutoConfiguration.class} )
public class DesignPatternsConfig {

    @Bean
    public AbstractChainContext abstractChainContext() {
        return new AbstractChainContext();
    }

}
