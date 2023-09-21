package org.example.app.views.user_view;

import org.example.app.views.view_util.InputOutputView;

public class UserCreateView extends InputOutputView {
        public String[] getData() {
        String title = "Enter first name: ";
        String firstName = inputReader.readString(title);

        title = "Enter last name: ";
        String lastName = inputReader.readString(title);

        title = "Enter nickname: ";
        String nickname = inputReader.readString(title);

        title = "Enter phone in format xxx xxx-xxxx: ";
        String phone = inputReader.readString(title);

        title = "Enter email in format example@mail.com: ";
        String email = inputReader.readString(title);

        return new String[]{firstName, lastName, nickname, phone, email};
    }
}
