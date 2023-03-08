package com.example.kotlintabsapp

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.ContextCompat

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Tab_3_Fragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_tab_3_, container, false)

        val tableLayout = rootView.findViewById<TableLayout>(R.id.table_layout)
        tableLayout.background = ContextCompat.getDrawable(requireContext(), R.drawable.table_background)

        val numCols = 2
        val numRows = 12
        val dividerHeight = 2
        val cellPadding = 15
        val textSize = 20f

        for (i in 0 until numRows) {
            val row = TableRow(requireContext())

            for (j in 0 until numCols) {
                val cell = TextView(requireContext())
                cell.text = "Line ${i+1}, Column ${j+1}"
                cell.setPadding(cellPadding, cellPadding, cellPadding, cellPadding)
                cell.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
                cell.setTextColor(Color.BLACK)
                row.addView(cell)

                if (j < numCols-1) {
                    val vDivider = View(requireContext())
                    vDivider.layoutParams = TableRow.LayoutParams(dividerHeight, TableRow.LayoutParams.MATCH_PARENT)
                    vDivider.setBackgroundColor(Color.GRAY)
                    row.addView(vDivider)
                }
            }

            if (i >= 0) {
                val hDivider = View(requireContext())
                    hDivider.layoutParams = TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, dividerHeight)
                    hDivider.setBackgroundColor(Color.GRAY)
                    tableLayout.addView(hDivider)
            }

            val rowParams = TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT)
            rowParams.setMargins(cellPadding, cellPadding, cellPadding, cellPadding)
            row.layoutParams = rowParams
            tableLayout.addView(row)
        }
        return rootView
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            Tab_3_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}