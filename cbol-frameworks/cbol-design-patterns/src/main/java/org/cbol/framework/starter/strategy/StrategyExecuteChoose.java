package org.cbol.framework.starter.strategy;

import org.cbol.framework.starter.web.ApplicationContextHolder;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StrategyExecuteChoose implements InitializingBean {

    private final Map<String, AbstractExecuteStrategy> abstractExecuteStrategyMap = new HashMap<>();


    public AbstractExecuteStrategy choose(String mark) {
        return Optional.ofNullable(abstractExecuteStrategyMap.get(mark))
                .orElseThrow(() -> new RuntimeException(String.format("s%未发现执行策略", mark)));
    }

    public <REQUEST> void chooseAndExecute(String mark,REQUEST requestParam) {
        AbstractExecuteStrategy executeStrategy = choose(mark);
        executeStrategy.execute(requestParam);
    }

    public <REQUEST, RESPONSE> RESPONSE chooseAndExecuteResp(String mark,REQUEST requestParam) {
        AbstractExecuteStrategy executeStrategy = choose(mark);
        return (RESPONSE) executeStrategy.executeRes(requestParam);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, AbstractExecuteStrategy> strategyMap = ApplicationContextHolder.getBeansOfType(AbstractExecuteStrategy.class);
        strategyMap.forEach((beanName,bean)->{
            AbstractExecuteStrategy abstractExecuteStrategy = abstractExecuteStrategyMap.get(bean.mark());
            if (abstractExecuteStrategy != null){
                throw new RuntimeException(String.format("[s%]重复的执行策略", bean.mark()));
            }
            abstractExecuteStrategyMap.put(bean.mark(), bean);
        });
    }
}
