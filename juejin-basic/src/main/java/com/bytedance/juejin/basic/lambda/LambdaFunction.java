package com.bytedance.juejin.basic.lambda;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public interface LambdaFunction extends Serializable {

    Map<Class<?>, SerializedLambda> cache = new ConcurrentHashMap<>();

    default SerializedLambda getSerializedLambda() {
        return cache.computeIfAbsent(this.getClass(), new MappingFunction(this));
    }

    @AllArgsConstructor
    class MappingFunction implements Function<Class<?>, SerializedLambda> {

        private final Object target;

        @SneakyThrows
        @Override
        public SerializedLambda apply(Class<?> clazz) {
            Method method = clazz.getDeclaredMethod("writeReplace");
            method.setAccessible(Boolean.TRUE);
            return (SerializedLambda) method.invoke(target);
        }
    }
}
