package com.java.redis.Aop;

import com.java.redis.Model.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(0)
public class ControllerAspect {

    private static Logger LOGGER=Logger.getLogger(ControllerAspect.class.getName());

    @Pointcut("execution(* com.java.redis.Controller.EmployeeController.save(..))")
    public void saveMethod(){}

    @Pointcut("execution(* com.java.redis.Controller.EmployeeController.update(..))")
    public void updateMethod(){}

    @Pointcut("execution(* com.java.redis.Controller.EmployeeController.getAll(..))")
    public void listMethod(){}

    @Pointcut("execution(* com.java.redis.Controller.EmployeeController.get(..))")
    public void getMethod(){}

    @Pointcut("execution(* com.java.redis.Controller.EmployeeController.delete(..))")
    public void deleteMethod(){}

    @After("saveMethod() || updateMethod()")
    public void save(JoinPoint joinPoint){
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        LOGGER.info(methodSignature.getMethod().getName()+" method worked!");
    }

    @AfterReturning(pointcut = "listMethod()",returning ="employees" )
    public void getEmpMethod(JoinPoint joinPoint, ResponseEntity<Iterable<Employee>> employees){
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        LOGGER.info(methodSignature.getMethod().getName()+" method worked!");
        LOGGER.info("Returning value => "+employees);
    }

    @AfterThrowing(pointcut = "listMethod() || updateMethod() || saveMethod() || deleteMethod() || getMethod()",throwing = "e")
    public void excHand(JoinPoint joinPoint,Exception e){
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        LOGGER.info(methodSignature.getMethod().getName()+" method worked!");
        LOGGER.info(e.getMessage());
    }



}
