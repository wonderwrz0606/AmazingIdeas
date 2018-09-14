package com.samnjoyin.www.services;

import com.samnjoyin.www.annotations.FirstClassLevelAnnotation;
import com.samnjoyin.www.annotations.FirstMethodLevelAnnotation;
import com.samnjoyin.www.annotations.FirstMethodLevelAnnotation.LEVEL;

import java.security.InvalidParameterException;
import java.util.Optional;

/**
 * This is the container class for any general purposes services
 */
@FirstClassLevelAnnotation
public class GeneralService {

    private static final String DEFAULT_MESSAGE = "default message";

    @FirstMethodLevelAnnotation(level = LEVEL.HIGH, id = 1, message = "Test message for annotation")
    public static void amazingPrint(final Optional<String> message) throws InvalidParameterException {
        if(message.isPresent()) {
            System.out.println(message.get());
        } else if(!DEFAULT_MESSAGE.isEmpty()) {
            System.out.println(DEFAULT_MESSAGE);
        } else {
            throw new InvalidParameterException("Empty string is not allowed");
        }
    }
}