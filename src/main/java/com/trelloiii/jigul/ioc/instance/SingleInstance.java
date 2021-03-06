package com.trelloiii.jigul.ioc.instance;

import com.trelloiii.jigul.scanner.AnnotationScanner;

import java.util.HashMap;

public class SingleInstance extends AnnotationScanner {

    private HashMap<Class,Object> singleObjects;
    private static SingleInstance singleInstance;
    private SingleInstance() {
        this.singleObjects = new HashMap<>();
    }
    public static SingleInstance build(){
        if(singleInstance==null){
            singleInstance=new SingleInstance();
        }
        return singleInstance;
    }

    public HashMap<Class, Object> getSingleObjects() {
        return singleObjects;
    }

    public Object instance(Class clazz)  {
        if(!singleObjects.containsKey(clazz)){
            Object object= null;
            try {
                object = clazz.newInstance();
                singleObjects.put(clazz,object);
                return object;
            } catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        else{
            return singleObjects.get(clazz);
        }
    }

    public Object instance(Object bean){
        Class clazz=bean.getClass();
        if(!singleObjects.containsKey(clazz)){
            try{
                singleObjects.put(clazz,bean);
                return bean;
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        else{
            return singleObjects.get(clazz);
        }
    }
}
