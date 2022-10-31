package com.bytedance.juejin.basic.condition;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;

/**
 * 查询条件
 */
@Getter
public class Conditions {

    /**
     * = 条件
     */
    private final Collection<Equal> equals = new LinkedList<>();

    /**
     * in 条件
     */
    private final Collection<In> ins = new LinkedList<>();

    /**
     * like 条件
     */
    private final Collection<Like> likes = new LinkedList<>();

    /**
     * order by 条件
     */
    private final Collection<OrderBy> orderBys = new LinkedList<>();

    /**
     * limit
     */
    private Limit limit;

    //有需要可以添加其他条件

    public LambdaConditions lambda() {
        LambdaConditions conditions = new LambdaConditions();
        conditions.getEquals().addAll(this.equals);
        conditions.getIns().addAll(this.ins);
        conditions.getLikes().addAll(this.likes);
        conditions.getOrderBys().addAll(this.orderBys);
        return conditions;
    }

    /**
     * 添加 =
     */
    public Conditions equal(String key, Object value) {
        equals.add(new Equal(key, value));
        return this;
    }

    /**
     * 添加 in
     */
    public Conditions in(String key, Collection<?> values) {
        ins.add(new In(key, values));
        return this;
    }

    /**
     * 添加 like
     */
    public Conditions like(String key, String value) {
        likes.add(new Like(key, value));
        return this;
    }

    /**
     * 添加 order by
     */
    public Conditions orderBy(String key, boolean desc) {
        orderBys.add(new OrderBy(key, desc));
        return this;
    }

    /**
     * 设置 limit
     */
    public Conditions limit(long start, long size) {
        limit = new Limit(start, size);
        return this;
    }

    /**
     * 设置 limit
     */
    public Conditions limit(long size) {
        limit = new Limit(0, size);
        return this;
    }

    /**
     * = 条件
     */
    @Getter
    @AllArgsConstructor
    public static class Equal {

        /**
         * = 的 key
         */
        private final String key;

        /**
         * = 的 value
         */
        private final Object value;
    }

    /**
     * in 条件
     */
    @Getter
    @AllArgsConstructor
    public static class In {

        /**
         * in 的 key
         */
        private final String key;

        /**
         * in 的 values
         */
        private final Collection<?> values;
    }

    /**
     * like 条件
     */
    @Getter
    @AllArgsConstructor
    public static class Like {

        /**
         * like 的 key
         */
        private final String key;

        /**
         * like 的 value
         */
        private final String value;
    }

    /**
     * order by 条件
     */
    @Getter
    @AllArgsConstructor
    public static class OrderBy {

        /**
         * order by 的 key
         */
        private final String key;

        /**
         * order by 是否倒序
         */
        private final boolean desc;
    }

    /**
     * limit 条件
     */
    @Getter
    @AllArgsConstructor
    public static class Limit {

        /**
         * limit 开始下标
         */
        private final long start;

        /**
         * limit 数量
         */
        private final long size;
    }
}
