package JavaBasic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname Annotation
 * @Description TODO
 * @Date 2020/8/13 11:56 上午
 * @Created by East
 */
// target 元注解可以指定该注解可被用于哪些位置
@Target(
        {
                ElementType.METHOD,
                ElementType.FIELD
        }
)
@Retention(RetentionPolicy.RUNTIME) // 定义注解的生命周期，RUNTIME表示在运行期间
public @interface Annotation {
    // @interface 来定义注解
    int type() default 0;

    String level() default "low";
}
