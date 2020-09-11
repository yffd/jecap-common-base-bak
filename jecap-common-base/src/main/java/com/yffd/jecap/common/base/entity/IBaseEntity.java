package com.yffd.jecap.common.base.entity;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 标识接口：持久化实体
 */
public interface IBaseEntity {

    default String nextId() {
        return this.uuid32();
    }

    /**
     * 使用ThreadLocalRandom获取UUID获取更优的效果 去掉"-"
     */
    default String uuid32() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new UUID(random.nextLong(), random.nextLong()).toString().replace("-", "");
    }

    /**
     * 使用ThreadLocalRandom获取UUID获取更优的效果
     */
    default String uuid36() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new UUID(random.nextLong(), random.nextLong()).toString();
    }

}
