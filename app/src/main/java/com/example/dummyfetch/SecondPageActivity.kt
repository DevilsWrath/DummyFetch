package com.example.dummyfetch

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dummyfetch.R

class SecondPageActivity : AppCompatActivity() {
    private lateinit var textViewId: TextView
    private lateinit var textViewFirstName: TextView
    private lateinit var textViewLastName: TextView
    private lateinit var textViewMaidenName: TextView
    private lateinit var textViewAge: TextView
    private lateinit var textViewGender: TextView
    private lateinit var textViewEmail: TextView
    private lateinit var textViewPhone: TextView
    private lateinit var textViewUsername: TextView
    private lateinit var textViewPassword: TextView
    private lateinit var textViewBirthDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        textViewId = findViewById(R.id.textViewId)
        textViewFirstName = findViewById(R.id.textViewFirstName)
        textViewLastName = findViewById(R.id.textViewLastName)
        textViewMaidenName = findViewById(R.id.textViewMaidenName)
        textViewAge = findViewById(R.id.textViewAge)
        textViewGender = findViewById(R.id.textViewGender)
        textViewEmail = findViewById(R.id.textViewEmail)
        textViewPhone = findViewById(R.id.textViewPhone)
        textViewUsername = findViewById(R.id.textViewUsername)
        textViewPassword = findViewById(R.id.textViewPassword)
        textViewBirthDate = findViewById(R.id.textViewBirthDate)

        // Retrieve the selectedData from the intent
        val selectedData = intent.getSerializableExtra("selectedData") as DummyData

        // Display the data in the corresponding TextView elements
        textViewId.text = "ID: ${selectedData.id}"
        textViewFirstName.text = "First Name: ${selectedData.firstName}"
        textViewLastName.text = "Last Name: ${selectedData.lastName}"
        textViewMaidenName.text = "Maiden Name: ${selectedData.maidenName}"
        textViewAge.text = "Age: ${selectedData.age}"
        textViewGender.text = "Gender: ${selectedData.gender}"
        textViewEmail.text = "Email: ${selectedData.email}"
        textViewPhone.text = "Phone: ${selectedData.phone}"
        textViewUsername.text = "Username: ${selectedData.username}"
        textViewPassword.text = "Password: ${selectedData.password}"
        textViewBirthDate.text = "Birth Date: ${selectedData.birthDate}"

        val returnButton: Button = findViewById(R.id.returnButton)
        returnButton.setOnClickListener {
            finish() // Return to the previous activity (FirstPageActivity)
        }
    }
}
