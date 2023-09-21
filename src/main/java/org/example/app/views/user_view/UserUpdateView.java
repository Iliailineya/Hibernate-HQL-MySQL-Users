package org.example.app.views.user_view;

import org.example.app.views.view_util.InputOutputView;

public class UserUpdateView extends InputOutputView {
    public String[] getData() {

        String title = "Enter user's ID: ";
        String id = inputReader.readString(title);

        title = "Enter new user name: ";
        String user_name = inputReader.readString(title);

        return new String[]{id, user_name};
    }
}
