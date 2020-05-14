package com.personal.controller;

import com.personal.common.Constants;
import com.personal.entity.User;
import com.personal.model.LoginRequest;
import com.personal.repository.UserRepository;
import com.personal.validator.CustomValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageSource messageSource;

    @PostMapping(value = "/adduser")
    public Object addUser(@RequestBody User user, BindingResult result, HttpServletRequest request) {
        boolean success = false;
        validateUser(result);

        if (result.hasErrors()) {
            List<String> errors = pushErrors(result);
            return errors;
        }

        User savedUser = userRepository.save(user);

        if (null != savedUser) {
            HttpSession session = request.getSession(true);
            session.setAttribute(Constants.USER_INFO, user);
        }

        return user;
    }

    private List<String> pushErrors(BindingResult result) {
        // TODO Auto-generated method stub
        List<String> errors = new ArrayList<String>();
        if (result.getFieldErrorCount() > 0) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errors.add(messageSource.getMessage(fieldError.getCodes()[1], null, null));
            }
        }
        return errors;
    }

    private void validateUser(BindingResult result) {
        // TODO Auto-generated method stub
        validateRequiredFields(result);

        if (!result.hasErrors()) {
            validateOtherRules(result);
        }
    }

    private void validateOtherRules(BindingResult result) {
        CustomValidator.rejectIfNotValidName(result, "firstName");
        CustomValidator.rejectIfNotValidName(result, "lastName");
        CustomValidator.rejectIfNotValidEmail(result, "email");
    }

    private void validateRequiredFields(BindingResult result) {
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "firstName", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "lastName", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "email", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "password", "required");
    }

    @PostMapping(value = "/signin")
    public User authenticateUser(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        User user = null;

        if (null != loginRequest && StringUtils.isNotBlank(loginRequest.getUserName()) && StringUtils.isNotBlank(loginRequest.getPassword())) {
            user = userRepository.findUserByEmailAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
        }

        if (null != user) {
            HttpSession session = request.getSession(true);
            session.setAttribute(Constants.USER_INFO, user);
        }

        return user;
    }

    @GetMapping(value = "/signout")
    public String signOutUser(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        session.removeAttribute(Constants.USER_INFO);

        return "success";
    }
}
