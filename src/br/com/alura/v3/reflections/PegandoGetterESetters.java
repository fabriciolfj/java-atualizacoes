package br.com.alura.v3.reflections;

import br.com.alura.entities.Melon;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class PegandoGetterESetters {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        /*for(PropertyDescriptor pd: Introspector.getBeanInfo(Melon.class).getPropertyDescriptors()) {
            if (pd.getReadMethod() != null && !"class".equals(pd.getName())) {
                System.out.println(pd.getReadMethod());
            }

            if (pd.getWriteMethod() != null && !"class".equals(pd.getName())) {
                System.out.println(pd.getWriteMethod());
            }
        }*/

        Melon melon = new Melon("Gac", 1000);
        var type = new PropertyDescriptor("name", Melon.class).getReadMethod().invoke(melon);
        System.out.println(type);

    }
}
