package com.cbol.common.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yaowenlei
 * @date 2023年11月25日 4:01 下午
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    public static final String SUCCESS_CODE = "0";

    private String code;

    private String message;

    private T data;

    public boolean idSuccess() {
        return SUCCESS_CODE.equals(code);
    }


}
