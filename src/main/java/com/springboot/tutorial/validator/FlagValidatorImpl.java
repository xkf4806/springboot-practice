package com.springboot.tutorial.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Description: 自定义验证器实现
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/23
 */
public class FlagValidatorImpl implements ConstraintValidator<FlagValidator, Object> {
   /**
    * 临时变量保存flag的值列表
    */
   private String value;

   /**
    * 初始化values的值
    * @param constraint
    */
   @Override
   public void initialize(FlagValidator constraint) {
      // 将注解内配置的值赋值给临时变量
      value = constraint.values();
   }

   /**
    * 实现验证
    * @param obj
    * @param context
    * @return
    */
   @Override
   public boolean isValid(Object obj, ConstraintValidatorContext context) {
      // 分割定义的有效值
      String[] values = value.split(",");
      boolean isFlag = false;

      // 遍历比较有效值
      for(String value1 : values) {
         if(value1.equals(obj)) {
            isFlag = true;
            break;
         }
      }
      return isFlag;
   }
}
