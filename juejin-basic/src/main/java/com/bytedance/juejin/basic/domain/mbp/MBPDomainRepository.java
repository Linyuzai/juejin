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
import com.bytedance.juejin.basic.domain.IdProvider;
import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.basic.page.Pages;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 基于 MyBatis-Plus 的通用存储
 *
 * @param <T> 领域模型
 * @param <P> 数据模型
 */
public abstract class MBPDomainRepository<T extends DomainObject, P extends IdProvider> extends AbstractDomainRepository<T, P> {

    /**
     * 插入一条数据
     */
    @Override
    protected void doCreate(P po) {
        getBaseMapper().insert(po);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void create(Collection<? extends T> objects) {
        super.create(objects);
    }

    /**
     * 插入多条数据
     */
    @Override
    protected void doCreate(Collection<? extends P> pos) {
        pos.forEach(this::doCreate);
    }

    /**
     * 更新一条数据
     */
    @Override
    protected void doUpdate(P po) {
        getBaseMapper().updateById(po);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void update(Collection<? extends T> objects) {
        super.update(objects);
    }

    /**
     * 更新多条数据
     */
    @Override
    protected void doUpdate(Collection<? extends P> pos) {
        pos.forEach(this::doUpdate);
    }

    /**
     * 删除一条数据
     */
    @Override
    protected void doDelete(P po) {
        doDelete(po.getId());
    }

    /**
     * 删除一条数据
     */
    @Override
    protected void doDelete(String id) {
        getBaseMapper().deleteById(id);
    }

    /**
     * 删除多条数据
     */
    @Override
    protected void doDelete(Collection<String> ids) {
        getBaseMapper().deleteBatchIds(ids);
    }

    /**
     * 根据 id 获得一条数据
     */
    @Override
    protected P doGet(String id) {
        return getBaseMapper().selectById(id);
    }

    /**
     * 根据 id 集合获得多条数据
     */
    @Override
    protected Collection<P> doSelect(Collection<String> ids) {
        return getBaseMapper().selectBatchIds(ids);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void delete(Conditions conditions) {
        super.delete(conditions);
    }

    /**
     * 条件删除数据
     */
    @Override
    protected void doDelete(Conditions conditions) {
        getBaseMapper().delete(getWrapper(conditions));
    }

    /**
     * 根据条件查询一条数据
     */
    @Override
    protected P doQuery(Conditions conditions) {
        List<P> list = doList(conditions);
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
    protected Long doCount(Conditions conditions) {
        return getBaseMapper().selectCount(getWrapper(conditions));
    }

    /**
     * 根据条件获得列表数据
     */
    @Override
    protected List<P> doList(Conditions conditions) {
        return getBaseMapper().selectList(getWrapper(conditions));
    }

    /**
     * 根据条件获得分页数据
     */
    @Override
    protected Pages<P> doPage(Conditions conditions, Pages.Args page) {
        IPage<P> p = new Page<>(page.getCurrent(), page.getSize());
        return toPages(getBaseMapper().selectPage(p, getWrapper(conditions)));
    }

    /**
     * 获得数据流
     */
    @Override
    protected Stream<P> doStream(Conditions conditions) {
        return doList(conditions).stream();
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

    /**
     * 匹配字段，借助 MyBatis-Plus 的工具获得实体字段与数据库字段的映射
     */
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
    protected Pages<P> toPages(IPage<P> p) {
        Pages<P> pages = new Pages<>();
        pages.setCurrent(p.getCurrent());
        pages.setSize(p.getSize());
        pages.setTotal(p.getTotal());
        pages.setPages(p.getPages());
        pages.setRecords(p.getRecords());
        return pages;
    }

    /**
     * 字段匹配类
     */
    public abstract Class<P> getFetchClass();

    /**
     * 获得 Mapper
     */
    public abstract BaseMapper<P> getBaseMapper();
}
