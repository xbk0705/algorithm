package com.xiabaike.interview;

/**
 * 枚举
 */
public enum InstanceEnum {

    INSTANCE,;

    private InstanceEnum() {

    }

    public static InstanceEnum getInstance() {
        return INSTANCE;
    }

}
