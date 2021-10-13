package app.christopher.calculatorintrasonics

class Model {

    private fun replaceN(string: String):String
    {
        val array=StringBuffer(string)
        if(array[0]=='-')
            array.setCharAt(0,'n')
        var i=0
        while(i<array.length)
        {
            if(array[i]=='-')
            {
                if(array[i-1]=='+' || array[i-1]=='÷' || array[i-1]=='x' || array[i-1]=='(')
                    array.setCharAt(i,'n')
            }
            i++
        }
        return array.toString()
    }
    fun result(string:String):String {
        val stringN = replaceN(string)
        val postfix = InfixToPostfix().postfixConversion(stringN)
        if(postfix == "Error")
            return postfix
        return try {
            val evaluation = ArithmeticOperations().evaluation(postfix)
            evaluation.toString()
        }catch (e:Exception) {
            "Error"
        }
    }
}