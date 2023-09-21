package org.example.app.services.operations;

import org.example.app.entities.User;
import org.example.app.exceptions.UpdateException;
import org.example.app.repositories.UserUpdateRepository;
import org.example.app.services.UserDataValidationService;
import org.example.app.validators.strategy.UpdateValidationStrategy;

import java.util.Map;

public class UserUpdateService {

    UserUpdateRepository repository;

    public UserUpdateService(UserUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateUser(String[] data) {

        UserDataValidationService updateService = new UserDataValidationService(new UpdateValidationStrategy());

        Map<String, String> errors = updateService.validateUser(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.updateUser(convertData(data));
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        user.setUserName(data[1]);
        return user;
    }
}
