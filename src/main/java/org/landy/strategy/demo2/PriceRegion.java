package org.landy.strategy.demo2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author landyl
 * @create 2:52 PM 05/12/2018
 */
//这是有效价格区间注解，可以给策略添加有效区间的设置
@Target(ElementType.TYPE)//表示只能给类添加该注解
@Retention(RetentionPolicy.RUNTIME)//这个必须要将注解保留在运行时
public @interface PriceRegion {

    int max() default Integer.MAX_VALUE;
    int min() default Integer.MIN_VALUE;

}
