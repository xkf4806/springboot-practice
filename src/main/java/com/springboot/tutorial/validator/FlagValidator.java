package com.springboot.tutorial.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Description: 自定义验证器注解
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/23
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = FlagValidatorImpl.class)
public @interface FlagValidator {
    // flag的多个有效值使用","分开
    String values();

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
