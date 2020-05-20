package com.thl.test.test;

import com.thl.test.annotation.Controller;
import com.thl.test.scanAnnotationUtils.AnnotationBean;
import com.thl.test.scanAnnotationUtils.AnnotationUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

public class test01 {

    public static void main(String[] args) {
        AnnotationUtils annotationUtils = new AnnotationUtils();
        Map<String, AnnotationBean> methodWithAnnotation = annotationUtils.getMethodWithAnnotation("com.thl.test.entity", Controller.class);
        Set<String> strings = methodWithAnnotation.keySet();
        for (String str : strings){
            AnnotationBean annotationBean = methodWithAnnotation.get(str);
            try {
                System.out.println("execute " + str + " method");
                annotationBean.getMethod().invoke(annotationBean.getObject());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }


}
