package org.example.app.validators;

import org.example.app.utils.Constants;

// Валідація телефона
public class PhoneValidator {
    public static boolean isPhoneValid(String phone) {
        return phone.isEmpty() || !phone.matches(Constants.PHONE_RGX);
    }
}