package com.example.demo.controllers.converter;

public interface Converter<T1, T2> {

    T2 convert(T1 t);

    T1 convertBack(T2 t);
}
