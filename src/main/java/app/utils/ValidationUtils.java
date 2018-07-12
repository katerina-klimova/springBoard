package app.utils;

import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtils {

    public static final int MIN_PASSWORD_LENGTH = 6;
    public static final String ERROR_PASSWORD_MESSAGE = "Пароль должен быть хотя бы " + MIN_PASSWORD_LENGTH + " символов!";
    private static final int MIN_NAME_LENGTH = 1;

    public static boolean validatePassword(String password){
        return password!= null && password.length() >= MIN_PASSWORD_LENGTH;
    }

    public static boolean validateName(String name){
        return name!=null && name.length()>= MIN_NAME_LENGTH;
    }

}
