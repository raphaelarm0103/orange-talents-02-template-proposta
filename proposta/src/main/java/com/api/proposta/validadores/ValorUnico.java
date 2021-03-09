package com.api.proposta.validadores;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ValorUnicoValidador.class})
@Target({ FIELD})
@Retention(RUNTIME)
public @interface ValorUnico {

    String message() default "Campo duplicado";
    String fieldName();
    Class<?> domainClass();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
