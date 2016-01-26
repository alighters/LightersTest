package com.lighters.demo.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by david on 15/12/29.
 */
public class Utils {

    public static Type getType(Class subclass) {

        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class)

        {
            throw new RuntimeException("Missing type parameter.");
        }

        ParameterizedType parametrized = (ParameterizedType) superclass;
        return parametrized.getActualTypeArguments()[0];
    }
}
