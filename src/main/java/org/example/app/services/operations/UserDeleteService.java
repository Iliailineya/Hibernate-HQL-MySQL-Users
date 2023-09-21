package org.example.app.services.operations;

import org.example.app.entities.User;
import org.example.app.exceptions.UpdateException;
import org.example.app.repositories.UserDeleteRepository;
import org.example.app.services.UserDataValidationService;
import org.example.app.validators.strategy.DeleteValidationStrategy;

import java.util.Map;

public class UserDeleteService {

    UserDeleteRepository repository;

    public UserDeleteService(UserDeleteRepository repository) {
        this.repository = repository;
    }

    public String deleteUser(String[] data) {

        UserDataValidationService deleteService = new UserDataValidationService(new DeleteValidationStrategy());

        Map<String, String> errors = deleteService.validateUser(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.deleteUser(convertData(data));
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        return user;
    }
}
