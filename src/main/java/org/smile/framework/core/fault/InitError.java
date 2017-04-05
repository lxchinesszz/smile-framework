package org.smile.framework.core.fault;

/**
 * @Package: org.smile.framework.core.fault
 * @Description: ${todo}
 * @author: liuxin
 * @date: 17/4/5 下午6:56
 */
public class InitError extends Error {
    public InitError(){
        super();
    }

    public InitError(String error){
        super(error);
    }

    public InitError(String error,Throwable cause){
        super(error,cause);
    }
}
