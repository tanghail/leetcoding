package com.thl.test.scanAnnotationUtils;

import com.thl.test.annotation.ResultMapping;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationUtils {

    public Map<String, AnnotationBean> getMethodWithAnnotation(String packageName, Class annotation){
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(annotation);

        Map<String, AnnotationBean> mapAnnotation = new HashMap<String, AnnotationBean>();

        //扫描指定的包下，指定的注解
        for (Class cls : classes){
            Method[] methods = cls.getMethods();

            //获取每一个类上面的被ResultMapping标记过的方法
            for (Method method : methods ){
                ResultMapping resultMappingAnnotation= method.getAnnotation(ResultMapping.class);
                if (null != resultMappingAnnotation){
                    AnnotationBean annotationBean = new AnnotationBean();
                    annotationBean.setMethod(method);
                    method.setAccessible(true);
                    try {
                        annotationBean.setObject(cls.newInstance());
                        mapAnnotation.put(resultMappingAnnotation.value(), annotationBean);
                        method.setAccessible(false);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return mapAnnotation;

    }
}
