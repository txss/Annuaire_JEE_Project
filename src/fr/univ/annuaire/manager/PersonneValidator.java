package fr.univ.annuaire.manager;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.univ.annuaire.beans.Personne;

@Service
public class PersonneValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Personne.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "personne.email");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "personne.password");
    }

}