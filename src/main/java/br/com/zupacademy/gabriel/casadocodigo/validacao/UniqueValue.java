package br.com.zupacademy.gabriel.casadocodigo.validacao;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueValueValidator.class})
public @interface UniqueValue {

    String message() default "{br.com.zupacademy.beanvalidation.uniquevalue}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String fieldName();
    Class<?> domainClass();
}
