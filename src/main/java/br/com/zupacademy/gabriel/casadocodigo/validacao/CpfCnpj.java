package br.com.zupacademy.gabriel.casadocodigo.validacao;


import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

@CPF
@CNPJ
@ReportAsSingleViolation
@ConstraintComposition(CompositionType.OR)
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CpfCnpj {

    String message() default "Deve ser um CPF ou CNPJ válido.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}