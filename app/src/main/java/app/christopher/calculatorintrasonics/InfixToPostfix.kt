package app.christopher.calculatorintrasonics

import java.util.*

class InfixToPostfix {

    private fun notNumeric(ch:Char):
            Boolean = when(ch) {
                '+','-','x','÷','(',')' -> true
        else-> false
            }

    private fun operatorPrecedence(ch: Char): Int = when(ch){'+','-'->1
        'x','÷'->2
        else-> -1
    }

    fun postfixConversion(string: String):String
    {
        var result=""
        val stack = Stack<Char>()
        for(s in string)
        {
            if(!notNumeric(s))
            {
                result+=s
            }
            else if (s == '(')
                stack.push(s)
            else if (s == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += " "+stack.pop()
                stack.pop()
            }
            else
            {
                while (!stack.isEmpty() && operatorPrecedence(s) <= operatorPrecedence(stack.peek())) {
                    result +=" ${stack.pop()}"
                }
                stack.push(s)
                result += " "
            }
        }
        result+=" "
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Error"
            result += stack.pop()+" "
        }
        return result.trim()
    }
}