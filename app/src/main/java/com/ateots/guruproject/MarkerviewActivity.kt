package com.ateots.guruproject

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.github.mikephil.charting.utils.Utils
import java.text.SimpleDateFormat
import java.util.*

class MarkerviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_markerview)

    }
}

class ExampleMarker : MarkerView {
    lateinit var tvContent: TextView

    constructor (context: Context?, layoutResource: Int) : super(context, layoutResource)
    {
        tvContent = findViewById(R.id.tvContent)
    }

    override fun draw(canvas: Canvas?) {
        canvas!!.translate(-(width/2).toFloat(), -height.toFloat())
        super.draw(canvas)
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        tvContent.text = e?.y.toString()
        super.refreshContent(e, highlight)
    }

}

/*class StickyDateAxisValueFormatter : ValueFormatter {
    private var c: GregorianCalendar
    private var chart: LineChart
    private var sticky: TextView
    private var lastFormattedValue = 1e9f
    private var lastMonth = 0
    private var lastYear = 0
    private var stickyMonth = -1
    private var stickyYear = -1
    private val mFormat =
        SimpleDateFormat("dd MMM", Locale.ENGLISH)

    constructor(chart: LineChart, sticky: TextView) {
        c = GregorianCalendar()
        this.chart = chart
        this.sticky = sticky
    }

    override fun getFormattedValue(value: Float): String? {
        if (value < chart.lowestVisibleX) {
            return ""
        }

        val days: Float = value
        val isFirstValue: Boolean = value < lastFormattedValue

        if (isFirstValue) {
            lastMonth = 50
            lastYear = 5000

            c.set(2020, 8, 10)
            c.add(GregorianCalendar.DATE, chart.lowestVisibleX.toInt())

            stickyMonth = c.get(GregorianCalendar.MONTH)
            stickyYear = c.get(GregorianCalendar.YEAR)

            val stickyText: String = mFormat.format(c.time)
            sticky.setText(stickyText)
        }

        c.set(2020, 8, 10)
        c.add(GregorianCalendar.DATE, days.toInt())
        val d: Date = c.time

        val dayOfMonth: Int = c.get(GregorianCalendar.DAY_OF_MONTH)
        val month: Int = c.get(GregorianCalendar.MONTH)
        val year: Int = c.get(GregorianCalendar.YEAR)

        val monthString: String = mFormat.format(d)

        if ((month > stickyMonth || year > stickyYear) && !isFirstValue) {
            stickyMonth = month
            stickyYear = year
            val stickyText: String = monthString + "\n" + year
            sticky.setText(stickyText)
        }

        val ret: String

        if ((month > lastMonth || year > lastYear) && isFirstValue) {
            ret = monthString
        } else {
            ret = dayOfMonth.toString();
        }

        lastMonth = month
        lastYear = year
        lastFormattedValue = value

        return month.toString() + "월" + ret + "일"
    }
}*/

