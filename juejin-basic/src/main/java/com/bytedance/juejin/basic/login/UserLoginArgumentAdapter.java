package com.bytedance.juejin.basic.login;

import com.github.linyuzai.domain.core.DomainObject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserLoginArgumentAdapter extends AbstractLoginArgumentAdapter {

    private final Class<? extends DomainObject> parameterType;
}
