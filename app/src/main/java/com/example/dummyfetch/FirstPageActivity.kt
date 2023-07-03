package com.example.dummyfetch

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dummyfetch.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable

class FirstPageActivity : AppCompatActivity() {
    private lateinit var apiService: DummyApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        // Initialize Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(DummyApiService::class.java)

        fetchData()
    }

    private fun fetchData() {
        apiService.getDummyData().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val dummyDataList = apiResponse?.users
                    populateTable(dummyDataList)
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e(TAG, "API error: $errorBody")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e(TAG, "Network failure: ${t.message}")

            }
        })
    }


    private fun populateTable(dummyDataList: List<DummyData>?) {
        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)

        dummyDataList?.forEach { dummyData ->
            val tableRow = TableRow(this)

            val idTextView = TextView(this)
            idTextView.text = dummyData.id.toString()
            tableRow.addView(idTextView)

            val nameTextView = TextView(this)
            nameTextView.text = dummyData.firstName
            tableRow.addView(nameTextView)

            val descriptionTextView = TextView(this)
            descriptionTextView.text = dummyData.lastName
            tableRow.addView(descriptionTextView)

            tableRow.setOnClickListener {
                navigateToSecondPage(dummyData)
            }

            tableLayout.addView(tableRow)
        }
    }

    private fun navigateToSecondPage(selectedData: DummyData) {
        val intent = Intent(this, SecondPageActivity::class.java)
        intent.putExtra("selectedData", selectedData as Serializable)
        startActivity(intent)
    }
}