package com.bytedance.juejin.basic.lambda;

@Deprecated
@FunctionalInterface
public interface MethodFunction<T> extends LambdaFunction {

    T get();
}
