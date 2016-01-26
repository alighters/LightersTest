package com.lighters.demo.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by david on 15/12/24.
 */
public class GenericTest {

    private Callback callback;

    public GenericTest(Callback callback) {
        this.callback = callback;
    }


    public void excute() {
        Type type = getInterfaceType(callback.getClass());
        System.out.print(type);
    }


    public static void main(String[] args) {

        Callback<List<String>> callback = new Callback<List<String>>() {
            @Override
            public void excute(List<String> strings) {
                System.out.println(strings);
            }
        };
        new GenericTest(callback).excute();

    }

    public static Type getType(Class subclass) {

        Type superclass = subclass.getInterfaces()[0];
        if (superclass instanceof Class)

        {
            throw new RuntimeException("Missing type parameter.");
        }

        ParameterizedType parametrized = (ParameterizedType) superclass;
        return parametrized.getActualTypeArguments()[0];
    }

    public static Type getInterfaceType(Class clazz) {

        Type[] genericInterfaces = clazz.getGenericInterfaces();
        for ( Type genericInterface   : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                Type[] genericTypes = ((ParameterizedType) genericInterface).getActualTypeArguments();
                for (Type genericType : genericTypes) {
                    return genericType;
                }
            }
        }
        return  null;
    }
}
