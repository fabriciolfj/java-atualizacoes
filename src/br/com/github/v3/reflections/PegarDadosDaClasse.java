package br.com.github.v3.reflections;

import br.com.github.entities.Melon;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

public class PegarDadosDaClasse {

    public static void main(String[] args) {
        Melon melon = new Melon("", 0);

        Class<?> clazz = melon.getClass();

        System.out.println("Name " + clazz.getName());
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println("Canonical name: " + clazz.getCanonicalName());

        int modifiers = clazz.getModifiers();

        System.out.println("is public? " + Modifier.isPublic(modifiers));
        System.out.println("is final? " + Modifier.isFinal(modifiers));
        System.out.println("is private? " + Modifier.isPrivate(modifiers));

        Class<?>[] interfaces = clazz.getInterfaces();
        Stream.of(interfaces).forEach(v -> System.out.println("Interfaces: " + v.getSimpleName()));

        var constructors = clazz.getConstructors();
        Stream.of(constructors).forEach(v -> System.out.println("Constructor " + v.toString()));

        var fields = clazz.getDeclaredFields();
        Stream.of(fields).forEach(v ->  System.out.println("Field: " + v.getName() + " acessible: " + v.isAccessible()));

        var methods = clazz.getMethods();
        System.out.println("Methods: " + Arrays.toString(methods));

        var superClass = clazz.getSuperclass();
        System.out.println("Superclass: " + superClass.getSimpleName());

        System.out.println("Type: " + int.class.getTypeName());
        System.out.println("Type: " + clazz.getTypeName());
        System.out.println("Description: " + clazz.toGenericString());
        System.out.println("Description jdk12: " + clazz.descriptorString());

        String[] strings = new String[] { "1", "2", "3"};
        System.out.println("Component type: " + strings.getClass().componentType());
    }
}
