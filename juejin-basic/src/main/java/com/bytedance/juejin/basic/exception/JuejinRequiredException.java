package com.bytedance.juejin.basic.exception;

import com.bytedance.juejin.basic.lambda.ClassFunction;
import com.bytedance.juejin.basic.lambda.LambdaFunction;

/**
 * 值为 null 的异常
 */
public class JuejinRequiredException extends JuejinException {

    public <T, R> JuejinRequiredException(ClassFunction<T, R> cf) {
        this(LambdaFunction.getClassName(cf.getSerializedLambda())
                + " " +
                LambdaFunction.getMethodName(cf.getSerializedLambda()).lowercaseFirst());
    }

    public <T, R> JuejinRequiredException(String target) {
        super(target + " required");
    }
}
