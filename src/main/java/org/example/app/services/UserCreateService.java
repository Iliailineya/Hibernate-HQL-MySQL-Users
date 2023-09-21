package org.example.app.services;

import lombok.AllArgsConstructor;
import org.example.app.entities.User1;
import org.example.app.exceptions.CreateException;
import org.example.app.repositories.UserCreateRepository;
import org.example.app.utils.Constants;
import org.example.app.validators.EmailValidator;
import org.example.app.validators.PhoneValidator;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class UserCreateService {

    UserCreateRepository repository;

    public String createUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }

        return repository.createUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty())
            errors.put("first name", Constants.INPUT_REQ_MSG);

        if (data[1].isEmpty())
            errors.put("last name", Constants.INPUT_REQ_MSG);

        if (data[2].isEmpty())
            errors.put("nickname", Constants.INPUT_REQ_MSG);

        if (PhoneValidator.isPhoneValid(data[3]))
            errors.put("phone", Constants.WRONG_PHONE_MSG);

        if (EmailValidator.isEmailValid(data[4]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }

    private User1 convertData(String[] data) {
        User1 user1 = new User1();
        user1.setFirstName(data[0]);
        user1.setLastName(data[1]);
        user1.setNickname(data[2]);
        user1.setPhone(data[3]);
        user1.setEmail(data[4]);
        return user1;
    }
}
