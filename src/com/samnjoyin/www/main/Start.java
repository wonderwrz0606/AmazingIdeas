package com.samnjoyin.www.main;

import com.samnjoyin.www.annotations.FirstClassLevelAnnotation;
import com.samnjoyin.www.annotations.FirstMethodLevelAnnotation;
import com.samnjoyin.www.services.GeneralService;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * Start point of this program, most of the part is used for reflection
 */
public class Start {
    public static void main(String[] args) {
        //Test method execution
        testMethodItself();

        //Test annotation reflection
        testReflection();
    }

    private static void testReflection() {
        //Get the Class object of GeneralService
        Class<GeneralService> generalServiceClass = GeneralService.class;

        //Check if this Class is annotated
        if(generalServiceClass.isAnnotationPresent(FirstClassLevelAnnotation.class)) {

            //Get the Class Level Annotation
            Annotation annotation = generalServiceClass.getAnnotation(FirstClassLevelAnnotation.class);

            //Process all the Method Level Annotations
            for(Method method : generalServiceClass.getDeclaredMethods()) {
                Annotation methodAnnotation = method.getAnnotation(FirstMethodLevelAnnotation.class);
                FirstMethodLevelAnnotation firstMethodLevelAnnotation = (FirstMethodLevelAnnotation)methodAnnotation;

                //Print out the members of this method annotation
                System.out.println(String.format("%s: %s = %s", FirstMethodLevelAnnotation.class.getName(), "level", firstMethodLevelAnnotation.level().toString()));
                System.out.println(String.format("%s: %s = %s", FirstMethodLevelAnnotation.class.getName(), "id", firstMethodLevelAnnotation.id()));
                System.out.println(String.format("%s: %s = %s", FirstMethodLevelAnnotation.class.getName(), "message", firstMethodLevelAnnotation.message()));
            }
        }
    }

    private static void testMethodItself() {
        //Give a empty string as input
        GeneralService.amazingPrint(Optional.empty());
    }
}
