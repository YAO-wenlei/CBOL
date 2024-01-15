package org.cbol.framework.starter.chain;

import org.springframework.core.Ordered;

/**
 * @author yaowenlei
 */
public interface AbstractChainHandler<T> extends Ordered {

    /**
     * 具体的执行策略，交由实现类实现
     * @param param 执行参数
     */
    void handler(T param);

    /**
     * mark标识，标记相同的实现类归属为同一类执行器，相同标记的实现类会组成执行链
     * @return 返回标识
     */
    String mark();

}
