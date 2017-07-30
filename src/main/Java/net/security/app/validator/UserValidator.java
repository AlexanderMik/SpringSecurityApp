package net.security.app.validator;

import net.security.app.model.User;
import net.security.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator  implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (user.getName().length() < 6 || user.getName().length() > 24)
            errors.rejectValue("username", "Size.Username");

        if (userService.findByName(user.getName()) != null)
            errors.rejectValue("username", "Duplicate.Username");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 6 || user.getPassword().length() > 32)
            errors.rejectValue("password", "Size.Password");

        if (!user.getPassword().equals(user.getConfirmPassword()))
            errors.rejectValue("confirmPassword", "Different.Passwords");
    }
}