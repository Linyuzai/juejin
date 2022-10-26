package com.bytedance.juejin.basic.lambda;

@FunctionalInterface
public interface MethodFunction<T> extends LambdaFunction {

    T get();
}
