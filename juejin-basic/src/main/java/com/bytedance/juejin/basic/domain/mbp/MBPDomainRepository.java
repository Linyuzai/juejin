package com.bytedance.juejin.basic.domain.mbp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.ColumnCache;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.AbstractDomainRepository;
import com.bytedance.juejin.basic.domain.DomainObject;
import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.basic.page.Pages;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 基于 MyBatis-Plus 的通用存储
 *
 * @param <T> 领域模型
 * @param <P> 数据模型
 */
public abstract class MBPDomainRepository<T extends DomainObject, P> extends AbstractDomainRepository<T, P> {

    /**
     * 插入一条数据
     */
    @Override
    public void create(T object) {
        getBaseMapper().insert(do2po(object));
    }

    /**
     * 插入多条数据
     */
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void create(Collection<? extends T> objects) {
        objects.forEach(this::create);
    }

    /**
     * 更新一条数据
     */
    @Override
    public void update(T object) {
        getBaseMapper().updateById(do2po(object));
    }

    /**
     * 更新多条数据
     */
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void update(Collection<? extends T> objects) {
        objects.forEach(this::update);
    }

    /**
     * 删除一条数据
     */
    @Override
    public void delete(T object) {
        getBaseMapper().deleteById(object.getId());
    }

    /**
     * 删除多条数据
     */
    @Override
    public void delete(Collection<? extends T> objects) {
        Set<String> ids = objects.stream()
                .map(DomainObject::getId)
                .collect(Collectors.toSet());
        getBaseMapper().deleteBatchIds(ids);
    }

    /**
     * 根据 id 获得一条数据
     */
    @Override
    public T get(String id) {
        P po = getBaseMapper().selectById(id);
        if (po == null) {
            return null;
        }
        return po2do(po);
    }

    /**
     * 根据 id 集合获得多条数据
     */
    @Override
    public Collection<T> select(Collection<String> ids) {
        return getBaseMapper()
                .selectBatchIds(ids)
                .stream()
                .map(this::po2do)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Conditions conditions) {
        getBaseMapper().delete(getWrapper(conditions));
    }

    /**
     * 根据条件查询一条数据
     */
    @Override
    public T query(Conditions conditions) {
        List<T> list = list(conditions);
        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new JuejinException("存在多条数据");
        }
    }

    /**
     * 根据条件获得数量
     */
    @Override
    public Long count(Conditions conditions) {
        return getBaseMapper().selectCount(getWrapper(conditions));
    }

    /**
     * 根据条件获得列表数据
     */
    @Override
    public List<T> list(Conditions conditions) {
        return getBaseMapper()
                .selectList(getWrapper(conditions))
                .stream()
                .map(this::po2do)
                .collect(Collectors.toList());
    }

    /**
     * 根据条件获得分页数据
     */
    @Override
    public Pages<T> page(Conditions conditions, Pages.Args page) {
        IPage<P> p = new Page<>(page.getCurrent(), page.getSize());
        return toPages(
                getBaseMapper().selectPage(p, getWrapper(conditions)),
                this::po2do);
    }

    @Override
    public Stream<T> stream(Conditions conditions) {
        return list(conditions).stream();
    }

    /**
     * 根据条件生成 Wrapper
     */
    protected Wrapper<P> getWrapper(Conditions conditions) {
        QueryWrapper<P> wrapper = new QueryWrapper<>();
        conditions.getEquals().forEach(it ->
                wrapper.eq(fetchColumn(getFetchClass(), it.getKey()), it.getValue()));
        conditions.getNulls().forEach(it ->
                wrapper.isNull(fetchColumn(getFetchClass(), it.getKey())));
        conditions.getIns().forEach(it ->
                wrapper.in(fetchColumn(getFetchClass(), it.getKey()), it.getValues()));
        conditions.getLikes().forEach(it ->
                wrapper.like(fetchColumn(getFetchClass(), it.getKey()), it.getValue()));
        conditions.getOrderBys().forEach(it -> {
            if (it.isDesc()) {
                wrapper.orderByDesc(fetchColumn(getFetchClass(), it.getKey()));
            } else {
                wrapper.orderByAsc(fetchColumn(getFetchClass(), it.getKey()));
            }
        });
        return wrapper;
    }

    protected String fetchColumn(Class<P> clazz, String field) {
        Map<String, ColumnCache> columnMap = LambdaUtils.getColumnMap(clazz);
        ColumnCache columnCache = columnMap.get(LambdaUtils.formatKey(field));
        if (columnCache == null) {
            return field;
        }
        return columnCache.getColumn();
    }

    /**
     * 将 mbp 的 page 转为我们的领域 pages
     */
    protected Pages<T> toPages(IPage<P> p, Function<P, T> function) {
        Pages<T> pages = new Pages<>();
        pages.setCurrent(p.getCurrent());
        pages.setSize(p.getSize());
        pages.setTotal(p.getTotal());
        pages.setPages(p.getPages());
        pages.setRecords(p.getRecords()
                .stream()
                .map(function)
                .collect(Collectors.toList()));
        return pages;
    }

    public abstract Class<P> getFetchClass();

    /**
     * 获得 Mapper
     */
    public abstract BaseMapper<P> getBaseMapper();
}
