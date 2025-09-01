package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        /* XML Approach */
        Motor motor = context.getBean(Motor.class);
        motor.doWork();
        System.out.println("----");

        MotorXmlApproach motorXmlApproach = context.getBean(MotorXmlApproach.class);
        motorXmlApproach.doWork();
        System.out.println("----");

        /* Programmatic Approach */
        MotorProgrammaticApproach motorProgrammaticApproach = context.getBean(MotorProgrammaticApproach.class);
        motorProgrammaticApproach.doWork();
        System.out.println("----");

        /* Annotation Approach */
        MotorAnnotationApproach motorAnnotationApproach = context.getBean(MotorAnnotationApproach.class);
        motorAnnotationApproach.doWork();
        System.out.println("----");

        ConfigurableApplicationContext cfgContext = (ConfigurableApplicationContext) context;
        cfgContext.registerShutdownHook();
    }
}