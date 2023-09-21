package org.example.app.validators;

import org.example.app.constants.Constants;

// Валідація id
public class IdValidator {
    public static boolean isIdValid(String id) {
        return id.isEmpty() || !id.matches(Constants.ID_RGX);
    }
}