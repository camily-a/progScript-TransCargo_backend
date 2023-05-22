package org.fatec.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentValidator implements ConstraintValidator<DocumentConstraint, String> {

    @Override
    public void initialize(DocumentConstraint doc){

    }
    @Override
    public boolean isValid(String doc, ConstraintValidatorContext constraintValidatorContext){
        return doc != null && doc.matches("^\\d{11}$|^\\d{14}$");
    }
}