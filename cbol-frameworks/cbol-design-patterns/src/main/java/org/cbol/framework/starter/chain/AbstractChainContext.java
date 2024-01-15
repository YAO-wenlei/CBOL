package org.cbol.framework.starter.chain;

import cn.hutool.core.collection.CollectionUtil;
import org.cbol.framework.starter.web.ApplicationContextHolder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yaowenlei
 * @date 2024年01月15日 11:26 上午
 */
public final class AbstractChainContext<T> implements CommandLineRunner {
    private final Map<String, List<AbstractChainHandler>> abstractChainHandlerContainer  =new HashMap();

    public void handler(String mark, T param) {
        List<AbstractChainHandler> chainHandlerList = abstractChainHandlerContainer.get(mark);
        if (CollectionUtil.isEmpty(chainHandlerList)) {
            throw new RuntimeException(String.format("Not find chain handler with mark[%s]", mark));
        }
        chainHandlerList.forEach(each -> each.handler(param));
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String, AbstractChainHandler> chainHandlerMap = ApplicationContextHolder
                .getBeansOfType(AbstractChainHandler.class);
        chainHandlerMap.forEach((beanName,bean) ->{
            List<AbstractChainHandler> abstractChainHandlers = abstractChainHandlerContainer.get(bean.mark());
            if (CollectionUtil.isEmpty(abstractChainHandlers)){
                abstractChainHandlers = new LinkedList<>();
            }
            abstractChainHandlers.add(bean);
            List<AbstractChainHandler> handlerList = abstractChainHandlers.stream()
                    .sorted(Comparator.comparing(Ordered::getOrder)).collect(Collectors.toList());
            abstractChainHandlerContainer.put(bean.mark(), handlerList);
        });
    }

}
