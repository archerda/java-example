package com.github.archerda.jdk.lambda.condition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

/**
 * Create by archerda on 2016/11/27
 */
public class ConditionTest {

    public static void main(String[] args) {
        Collection<Function<Context, Boolean>> conditions = new ArrayList<>();
        conditions.add(context -> "hello".equals(context.getName()));
        conditions.add(context -> "java".equals(context.getName()));
        conditions.add(context -> "function".equals(context.getName()));

        Context context = new Context();
        context.setName("java");

        Context context1 = new Context();
        context1.setName("objective-c");

        System.out.println(judge(context, conditions));
        System.out.println(judge(context1, conditions));
    }

    private static boolean judge(Context context, Collection<Function<Context, Boolean>>
            conditions) {
        for (Function<Context, Boolean> cond : conditions) {
            if (cond.apply(context)) {
                return true;
            }
        }

        return false;
    }
}

class Context {

    private String name;

    public Context() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Context{" +
                "name='" + name + '\'' +
                '}';
    }
}
