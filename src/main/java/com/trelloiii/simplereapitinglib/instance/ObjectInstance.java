package com.trelloiii.simplereapitinglib.instance;

import com.trelloiii.simplereapitinglib.AutoGenerated;
import com.trelloiii.simplereapitinglib.scanner.test.Person;

import java.util.List;

public class ObjectInstance {

    private SingleInstance singleInstance;
    public ObjectInstance(List<Class<?>> classes) {
        singleInstance=SingleInstance.build();
        checkInstanceType(classes);
    }

    private void checkInstanceType(List<Class<?>> classes){
        for(Class clazz:classes){
            AutoGenerated autoGenerated=(AutoGenerated) clazz.getAnnotation(AutoGenerated.class);
            if(autoGenerated.instanceType().equals(InstanceType.SINGLE)){
                singleInstance(clazz);
            }
            else if(autoGenerated.instanceType().equals(InstanceType.MULTI)){
                multiInstance(clazz);
            }
            else{
                throw new IllegalArgumentException("Wrong InstanceTypeValue in class: "+clazz.getName());
            }
        }
    }

    private void multiInstance(Class clazz) {
        System.out.println("class "+clazz.getName()+" is multi instance");
    }

    private void singleInstance(Class clazz) {
        System.out.println("class "+clazz.getName()+" is single instance");
        singleInstance.instance(clazz);
    }
}
