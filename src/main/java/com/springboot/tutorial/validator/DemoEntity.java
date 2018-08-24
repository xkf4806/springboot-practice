package com.springboot.tutorial.validator;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

/**
 * Description: 待校验实体数据
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/23
 */
@Data
public class DemoEntity {
    @NotBlank
    @Length(min = 2, max = 10, message = "姓名最大长度为10，最小长度为2")
    private String name;
    @Min(value = 1)
    private Integer age;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @FlagValidator(values = "1,2,3", message = "flag有效值为1,2,3")
    private String flag;
}
