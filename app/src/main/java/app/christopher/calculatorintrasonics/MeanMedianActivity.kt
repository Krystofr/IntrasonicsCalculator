package app.christopher.calculatorintrasonics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mean_median.*

class MeanMedianActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mean_median)

        title = "Mean/Median"

        mean_button.setOnClickListener {
            computeMean()
        }

        median_button.setOnClickListener {
            computeMedian()
        }
    }

    // the array double[] median MUST BE SORTED
    private fun computeMedian() {
        val fig1 = num1.text.toString().trim()
        val fig2 = num2.text.toString().trim()
        val fig3 = num3.text.toString().trim()
        val fig4 = num4.text.toString().trim()
        val fig5 = num5.text.toString().trim()

        val numb1 = fig1.toDouble()
        val numb2 = fig2.toDouble()
        val numb3 = fig3.toDouble()
        val numb4 = fig4.toDouble()
        val numb5 = fig5.toDouble()

        val numberList: MutableList<Double> = ArrayList()
        numberList.add(0, numb1)
        numberList.add(1, numb2)
        numberList.add(2, numb3)
        numberList.add(3, numb4)
        numberList.add(4, numb5)

        //Arrays.sort(mean)
        val middle = numberList.size/2
         if (numberList.size % 2 == 1) {
             """${numberList[middle - 1]}${numberList[middle] / 2.0}""".also { median_result.text = it }
             //median_result.text = """${numberList[median.size / 2]}"""
         }
    }

    //Mean computation
    private fun computeMean() {
        //val mean = arrayOf(45, 5, 21, 101, 229, 3)

        val fig1 = num1.text.toString().trim()
        val fig2 = num2.text.toString().trim()
        val fig3 = num3.text.toString().trim()
        val fig4 = num4.text.toString().trim()
        val fig5 = num5.text.toString().trim()

        val numb1 = fig1.toDouble()
        val numb2 = fig2.toDouble()
        val numb3 = fig3.toDouble()
        val numb4 = fig4.toDouble()
        val numb5 = fig5.toDouble()


        val numberList: MutableList<Double> = ArrayList()
        numberList.add(0, numb1)
        numberList.add(1, numb2)
        numberList.add(2, numb3)
        numberList.add(3, numb4)
        numberList.add(4, numb5)

        var sum = 0.0
        for (iter in numberList.indices){
            sum += numberList[iter]
        }
        mean_result.text = """${sum / numberList.size}"""
    }
}