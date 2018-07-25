package app.utils;

import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidationUtils {

    public static final int MIN_PASSWORD_LENGTH = 6;
    public static final String ERROR_PASSWORD_MESSAGE = "Пароль должен быть хотя бы " + MIN_PASSWORD_LENGTH + " символов!";
    private static final int MIN_NAME_LENGTH = 1;
    private static final BigDecimal MIN_COST = BigDecimal.ZERO;

    public static boolean validatePassword(String password){
        return password!= null && password.length() >= MIN_PASSWORD_LENGTH;
    }

    public static boolean validateName(String name){
        return name!=null && name.length()>= MIN_NAME_LENGTH;
    }

    public static boolean validateCost(BigDecimal cost) {
        return (cost!=null)&& (MIN_COST.compareTo(cost)<0);
    }
}
