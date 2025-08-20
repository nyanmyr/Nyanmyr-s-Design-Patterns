package interpreter;

// Context: holds the input string

import java.util.Arrays;
import java.util.List;

class Context {
    private final String input;
    private String output = "";

    public Context(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void appendOutput(String text) {
        output += text;
    }

    public String getOutput() {
        return output;
    }
}

// Abstract Expression
interface Expression {
    void interpret(Context context);
}

// Terminal Expressions
class GiveExpression implements Expression {
    public void interpret(Context context) {
        if (context.getInput().contains("bloop bloop") || context.getInput().contains("blee bleep")) {
            context.appendOutput("give");
        }
    }
}

class MeExpression implements Expression {
    public void interpret(Context context) {
        if (context.getInput().contains("loo")) {
            context.appendOutput(" me");
        }
    }
}

class YouExpression implements Expression {
    public void interpret(Context context) {
        if (context.getInput().contains("leep")) {
            context.appendOutput(" you");
        }
    }
}

class FoodExpression implements Expression {
    public void interpret(Context context) {
        if (context.getInput().contains("blopop") || context.getInput().contains("blepep")) {
            context.appendOutput(" food");
        }
    }
}

class QuestionExpression implements Expression {
    public void interpret(Context context) {
        if (context.getInput().contains("blep")) {
            context.appendOutput("? can you");
        }
    }
}

class PleaseExpression implements Expression {
    public void interpret(Context context) {
        if (context.getInput().contains("lep loop")) {
            context.appendOutput(" please");
        }
    }
}

public class Interpreter {

    public static void main(String[] args) {
        String slimeSpeech = "bloop bloop loo blep blopop lep loop";
        Context context = new Context(slimeSpeech);

        // Build AST (list of expressions)
        List<Expression> grammar = Arrays.asList(
            new GiveExpression(),
            new MeExpression(),
            new YouExpression(),
            new FoodExpression(),
            new QuestionExpression(),
            new PleaseExpression()
        );

        // Interpret
        for (Expression exp : grammar) {
            exp.interpret(context);
        }

        System.out.println("The slime said: " + slimeSpeech);
        System.out.println("Translated into English: " + context.getOutput().trim());
    }
}
