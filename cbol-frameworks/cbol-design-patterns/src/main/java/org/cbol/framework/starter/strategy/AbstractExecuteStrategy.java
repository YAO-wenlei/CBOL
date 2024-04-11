package org.cbol.framework.starter.strategy;

public interface AbstractExecuteStrategy<REQUEST,RESPONSE> {

    default String mark(){return null;}

    default void execute(REQUEST requestParam){}

    default RESPONSE executeRes(REQUEST requestParam){return null;}

}
