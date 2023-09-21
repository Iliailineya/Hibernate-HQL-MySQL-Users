package org.example.app.services.operations;

import org.example.app.entities.User;
import org.example.app.repositories.UserReadRepository;
import org.example.app.constants.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class UserReadService {

    private final UserReadRepository repository;

    public UserReadService(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readUsers() {
        List<User> users = repository.readUsers();

        if (users == null || users.isEmpty()) {
            return Constants.DATA_ABSENT_MSG;
        }

        StringBuilder result = new StringBuilder("\n______ USERS ___________\n");
        AtomicInteger count = new AtomicInteger(0);

        String userListing = users.stream()
                .map(user -> {
                    int index = count.incrementAndGet();
                    return String.format("%d) id: %d, %s %s, %s, %s\n",
                            index,
                            user.getId(),
                            user.getUserName(),
                            user.getFirstName(),
                            user.getLastName(),
                            user.getEmail());
                })
                .collect(Collectors.joining());

        result.append(userListing);

        return result.toString();
    }
}
