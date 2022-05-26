package br.com.alura.v3;

import br.com.alura.entities.Melon;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class UnaryOperatorTest {

    public static void main(String[] args) {
        var melons = new ArrayList<Melon>();
        melons.add(new Melon("apollo", 3000));
        melons.add(new Melon("jade", 3500));
        melons.add(new Melon("cantaloupe", 1500));
        melons.add(new Melon("hami", 1400));
        //trocar todos do mesmo tipo que tem gramas menor que 3000 para 3000
        UnaryOperator<Melon> operator = t -> (t.getGrama() < 3000) ? new Melon(t.getName(), 3000) : t;

        melons.replaceAll(operator);

        System.out.println(melons);

        UnaryOperator<Integer> mult = x -> x * 3;
        UnaryOperator<Integer> mult2 = x -> x + 5;

        System.out.println(calc(2, mult));
        System.out.println(calc(2, mult, mult2));
    }

    private static Integer calc(Integer value, UnaryOperator<Integer> form) {
        return form.apply(value);
    }

    private static Integer calc(Integer value, UnaryOperator<Integer> form, UnaryOperator<Integer> mult2) {
        return mult2.andThen(form).apply(value);
    }
}
