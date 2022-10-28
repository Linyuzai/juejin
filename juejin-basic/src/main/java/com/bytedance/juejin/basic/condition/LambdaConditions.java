package com.bytedance.juejin.basic.condition;

import com.bytedance.juejin.basic.lambda.ClassFunction;
import com.bytedance.juejin.basic.lambda.MethodFunction;

import java.lang.invoke.SerializedLambda;
import java.util.Collection;

public class LambdaConditions extends Conditions {

    @Override
    public LambdaConditions lambda() {
        return this;
    }

    public <T, R> Conditions equal(ClassFunction<T, R> cf, Object value) {
        SerializedLambda sl = cf.getSerializedLambda();
        return equal(generate(sl, true), value);
    }

    public <T> Conditions equal(MethodFunction<T> mf, Object value) {
        SerializedLambda sl = mf.getSerializedLambda();
        return equal(generate(sl, false), value);
    }

    public <T, R> Conditions in(ClassFunction<T, R> cf, Collection<?> values) {
        SerializedLambda sl = cf.getSerializedLambda();
        return in(generate(sl, true), values);
    }

    public <T> Conditions in(MethodFunction<T> mf, Collection<?> values) {
        SerializedLambda sl = mf.getSerializedLambda();
        return in(generate(sl, false), values);
    }

    public <T, R> Conditions like(ClassFunction<T, R> cf, String value) {
        SerializedLambda sl = cf.getSerializedLambda();
        return like(generate(sl, true), value);
    }

    public <T> Conditions like(MethodFunction<T> mf, String value) {
        SerializedLambda sl = mf.getSerializedLambda();
        return like(generate(sl, false), value);
    }

    public <T, R> Conditions orderBy(ClassFunction<T, R> cf, boolean desc) {
        SerializedLambda sl = cf.getSerializedLambda();
        return orderBy(generate(sl, true), desc);
    }

    public <T> Conditions orderBy(MethodFunction<T> mf, boolean desc) {
        SerializedLambda sl = mf.getSerializedLambda();
        return orderBy(generate(sl, false), desc);
    }

    protected String generate(SerializedLambda sl, boolean withClass) {
        String generate;
        if (withClass) {
            generate = getClassName(sl) + getMethodName(sl);
        } else {
            generate = getMethodName(sl);
        }
        return Character.toLowerCase(generate.charAt(0)) +
                generate.substring(1);
    }

    protected String getClassName(SerializedLambda sl) {
        return sl.getImplClass();
    }

    protected String getMethodName(SerializedLambda sl) {
        String methodName = sl.getImplMethodName();
        if (methodName.startsWith("get") && !methodName.equals("get")) {
            return methodName.substring(3);
        } else if (methodName.startsWith("is") && !methodName.equals("is")) {
            return methodName.substring(2);
        } else {
            return methodName;
        }
    }
}
