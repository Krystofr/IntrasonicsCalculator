package app.christopher.calculatorintrasonics

import java.util.*

class ArithmeticOperations {

    val mean : String = "MEAN"
    private fun notOperator(char: Char):Boolean=when(char)
    {
        '+','-','÷','x'->false
        else->true
    }
    fun evaluation(string: String):Double
    {
        var str=""
        val stack= Stack<Double>()
        for (ch in string)
        {
            if(notOperator(ch) && ch!=' ')
                str+=ch
            else if(ch==' ' && str !="")
            {
                stack.push(str.replace('n','-').toDouble())
                str=""}
            else if(!notOperator(ch))
            {
                val val1=stack.pop()
                val val2=stack.pop()
                when(ch)
                {
                    '+'-> stack.push(val2 + val1)
                    '-'-> stack.push(val2 - val1)
                    '÷'-> stack.push(val2 / val1)
                    'x'-> stack.push(val2 * val1)
                }
            }
        }
        return stack.pop()
    }
}