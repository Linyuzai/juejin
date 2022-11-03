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
        return equal(cf, value, true);
    }

    public <T, R> LambdaConditions equal(ClassFunction<T, R> cf, Object value, boolean prependClass) {
        SerializedLambda sl = cf.getSerializedLambda();
        equal(generate(sl, prependClass), value);
        return this;
    }

    @Deprecated
    public <T> LambdaConditions equal(MethodFunction<T> mf, Object value) {
        SerializedLambda sl = mf.getSerializedLambda();
        equal(generate(sl, false), value);
        return this;
    }

    public <T, R> LambdaConditions isNull(ClassFunction<T, R> cf) {
        return isNull(cf, true);
    }

    public <T, R> LambdaConditions isNull(ClassFunction<T, R> cf, boolean prependClass) {
        SerializedLambda sl = cf.getSerializedLambda();
        isNull(generate(sl, prependClass));
        return this;
    }

    @Deprecated
    public <T> LambdaConditions isNull(MethodFunction<T> mf) {
        SerializedLambda sl = mf.getSerializedLambda();
        isNull(generate(sl, false));
        return this;
    }

    public <T, R> LambdaConditions in(ClassFunction<T, R> cf, Collection<?> values) {
        return in(cf, values, true);
    }

    public <T, R> LambdaConditions in(ClassFunction<T, R> cf, Collection<?> values, boolean prependClass) {
        SerializedLambda sl = cf.getSerializedLambda();
        in(generate(sl, prependClass), values);
        return this;
    }

    @Deprecated
    public <T> LambdaConditions in(MethodFunction<T> mf, Collection<?> values) {
        SerializedLambda sl = mf.getSerializedLambda();
        in(generate(sl, false), values);
        return this;
    }

    public <T, R> LambdaConditions like(ClassFunction<T, R> cf, String value) {
        return like(cf, value, true);
    }

    public <T, R> LambdaConditions like(ClassFunction<T, R> cf, String value, boolean prependClass) {
        SerializedLambda sl = cf.getSerializedLambda();
        like(generate(sl, prependClass), value);
        return this;
    }

    @Deprecated
    public <T> LambdaConditions like(MethodFunction<T> mf, String value) {
        SerializedLambda sl = mf.getSerializedLambda();
        like(generate(sl, false), value);
        return this;
    }

    public <T, R> LambdaConditions orderBy(ClassFunction<T, R> cf, boolean desc) {
        return orderBy(cf, desc, true);
    }

    public <T, R> LambdaConditions orderBy(ClassFunction<T, R> cf, boolean desc, boolean prependClass) {
        SerializedLambda sl = cf.getSerializedLambda();
        orderBy(generate(sl, prependClass), desc);
        return this;
    }

    @Deprecated
    public <T> LambdaConditions orderBy(MethodFunction<T> mf, boolean desc) {
        SerializedLambda sl = mf.getSerializedLambda();
        orderBy(generate(sl, false), desc);
        return this;
    }

    protected String generate(SerializedLambda sl, boolean prependClass) {
        if (prependClass) {
            return LambdaFunction.getClassName(sl).lowercaseFirst().getValue() +
                    LambdaFunction.getMethodName(sl).getValue();
        } else {
            return LambdaFunction.getMethodName(sl).lowercaseFirst().getValue();
        }
    }
}
