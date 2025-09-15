package org.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MotorProgrammaticApproach implements InitializingBean, DisposableBean {
    public MotorProgrammaticApproach() {
        System.out.println("MotorProgrammaticApproach :: Constructor");
    }

    public void doWork() {
        System.out.println("MotorProgrammaticApproach Pulling Water...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MotorProgrammaticApproach Started ...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MotorProgrammaticApproach Stopped !!!!");
    }
}
