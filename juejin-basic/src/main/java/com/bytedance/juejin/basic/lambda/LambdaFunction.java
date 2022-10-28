package com.bytedance.juejin.basic.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
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

    static Name getClassName(SerializedLambda sl) {
        return new Name(sl.getImplClass());
    }

    static Name getMethodName(SerializedLambda sl) {
        return new Name(sl.getImplMethodName()).convertGetMethodToField();
    }

    @Getter
    @AllArgsConstructor
    class Name {

        private String value;

        public Name convertGetMethodToField() {
            if (value.startsWith("get") && !value.equals("get")) {
                value = value.substring(3);
            } else if (value.startsWith("is") && !value.equals("is")) {
                value = value.substring(2);
            }
            return this;
        }

        public Name lowercaseFirst() {
            value = Character.toLowerCase(value.charAt(0)) + value.substring(1);
            return this;
        }
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
