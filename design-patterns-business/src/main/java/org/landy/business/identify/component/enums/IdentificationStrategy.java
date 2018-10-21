package org.landy.business.identify.component.enums;

/**
 * 查询策略类型
 * @author landyl
 * @create 4:18 PM 09/04/2018
 */
public enum IdentificationStrategy {
    /**
     * 主键外键相结合
     */
    ALL("ALL",0),//indicates all the identify type
    /**
     * 组合主键策略
     */
    PRIMARY_KEY_COMBINATION("PRIMARY",1),
    /**
     * 组合外键策略
     */
    FOREIGN_KEY_COMBINATION("FOREIGN",2),

    ;

    public int value;
    public String name;

    IdentificationStrategy(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
