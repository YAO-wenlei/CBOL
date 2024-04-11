package org.cbol.framework.starter.strategy;

public interface AbstractExecuteStrategy<REQUEST,RESPONSE> {

    String mark();

    void execute(REQUEST requestParam);

    RESPONSE executeRes(REQUEST requestParam);

}
