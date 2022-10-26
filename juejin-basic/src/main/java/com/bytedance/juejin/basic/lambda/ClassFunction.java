package com.bytedance.juejin.basic.lambda;

@FunctionalInterface
public interface ClassFunction<T, R> extends LambdaFunction {

    R get(T t);
}
