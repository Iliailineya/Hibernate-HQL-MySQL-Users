package org.example.app.services.operations;

import lombok.AllArgsConstructor;
import org.example.app.entities.User;
import org.example.app.exceptions.CreateException;
import org.example.app.repositories.UserCreateRepository;
import org.example.app.services.UserDataValidationService;
import org.example.app.validators.strategy.CreateValidationStrategy;

import java.util.Map;

@AllArgsConstructor
public class UserCreateService {

    UserCreateRepository repository;

    public String createUser(String[] data) {

        UserDataValidationService createService = new UserDataValidationService(new CreateValidationStrategy());

        Map<String, String> errors = createService.validateUser(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }

        return repository.createUser(convertData(data));
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setUserName(data[0]);
        user.setFirstName(data[1]);
        user.setLastName(data[2]);
        user.setEmail(data[3]);
        return user;
    }
}
