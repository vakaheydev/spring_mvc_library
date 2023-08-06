package ru.vaka.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.vaka.springcourse.dao.PersonDAO;
import ru.vaka.springcourse.models.Person;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Person person = (Person) target;
//
//       if(personDAO.show(person.getEmail()).isPresent()) {
//           errors.rejectValue("email", "", "This email is already taken");
//       }

//       if(person.getName().length() < 2 || person.getName().length() > 30) {
//           errors.rejectValue("name", "", "Name should be between 2 and 30 characters");
//       }
//
//       if(person.getEmail().isEmpty()) {
//           errors.rejectValue("email", "", "Email can't be empty");
//       }
//
//       if(person.getAge() < 1) {
//           errors.rejectValue("age", "", "Age can't be negative or equals 0");
//       }

    }
}
