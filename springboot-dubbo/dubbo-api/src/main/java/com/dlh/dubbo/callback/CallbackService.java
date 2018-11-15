package com.dlh.dubbo.callback;

/**
 * @author wutao
 * @date 2018/11/13
 */
public interface CallbackService {

    void addListener(String key, CallbackListener listener);
}
