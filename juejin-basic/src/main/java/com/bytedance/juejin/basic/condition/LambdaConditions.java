package com.bytedance.juejin.basic.condition;

import com.bytedance.juejin.basic.lambda.ClassFunction;
import com.bytedance.juejin.basic.lambda.LambdaFunction;
import com.bytedance.juejin.basic.lambda.MethodFunction;

import java.lang.invoke.SerializedLambda;
import java.util.Collection;

public class LambdaConditions extends Conditions {

    @Override
    public LambdaConditions lambda() {
        return this;
    }

    public <T, R> LambdaConditions equal(ClassFunction<T, R> cf, Object value) {
        SerializedLambda sl = cf.getSerializedLambda();
        equal(generate(sl, true), value);
        return this;
    }

    public <T> LambdaConditions equal(MethodFunction<T> mf, Object value) {
        SerializedLambda sl = mf.getSerializedLambda();
        equal(generate(sl, false), value);
        return this;
    }

    public <T, R> LambdaConditions in(ClassFunction<T, R> cf, Collection<?> values) {
        SerializedLambda sl = cf.getSerializedLambda();
        in(generate(sl, true), values);
        return this;
    }

    public <T> LambdaConditions in(MethodFunction<T> mf, Collection<?> values) {
        SerializedLambda sl = mf.getSerializedLambda();
        in(generate(sl, false), values);
        return this;
    }

    public <T, R> LambdaConditions like(ClassFunction<T, R> cf, String value) {
        SerializedLambda sl = cf.getSerializedLambda();
        like(generate(sl, true), value);
        return this;
    }

    public <T> LambdaConditions like(MethodFunction<T> mf, String value) {
        SerializedLambda sl = mf.getSerializedLambda();
        like(generate(sl, false), value);
        return this;
    }

    public <T, R> LambdaConditions orderBy(ClassFunction<T, R> cf, boolean desc) {
        SerializedLambda sl = cf.getSerializedLambda();
        orderBy(generate(sl, true), desc);
        return this;
    }

    public <T> LambdaConditions orderBy(MethodFunction<T> mf, boolean desc) {
        SerializedLambda sl = mf.getSerializedLambda();
        orderBy(generate(sl, false), desc);
        return this;
    }

    protected String generate(SerializedLambda sl, boolean withClass) {
        if (withClass) {
            return LambdaFunction.getClassName(sl).lowercaseFirst().getValue() +
                    LambdaFunction.getMethodName(sl).getValue();
        } else {
            return LambdaFunction.getMethodName(sl).lowercaseFirst().getValue();
        }
    }
}
