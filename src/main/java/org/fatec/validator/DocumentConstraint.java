package org.fatec.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DocumentValidator.class)
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DocumentConstraint {
    String message() default "Documento inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}