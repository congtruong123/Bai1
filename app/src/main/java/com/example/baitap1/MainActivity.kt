package com.example.baitap1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var cbTerms: CheckBox
    private lateinit var btnSave: Button
    private lateinit var recyclerView: RecyclerView

    private val userList = mutableListOf<User>()
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFullName = findViewById(R.id.etFullName)
        etEmail = findViewById(R.id.etEmail)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        rgGender = findViewById(R.id.rgGender)
        cbTerms = findViewById(R.id.cbTerms)
        btnSave = findViewById(R.id.btnSave)
        recyclerView = findViewById(R.id.recyclerView)

        // Set up RecyclerView
        userAdapter = UserAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        // Handle Save button click
        btnSave.setOnClickListener {
            saveUserInfo()
        }
    }

    private fun saveUserInfo() {
        val fullName = etFullName.text.toString()
        val email = etEmail.text.toString()
        val phoneNumber = etPhoneNumber.text.toString()

        // Get selected gender
        val selectedGenderId = rgGender.checkedRadioButtonId
        val gender = when (selectedGenderId) {
            R.id.rbMale -> "Nam"
            R.id.rbFemale -> "Nữ"
            R.id.rbOther -> "Khác"
            else -> ""
        }

        // Check if terms are accepted
        if (!cbTerms.isChecked) {
            Toast.makeText(this, "Vui lòng đồng ý với điều khoản sử dụng", Toast.LENGTH_SHORT).show()
            return
        }

        // Add user to the list
        val user = User(fullName, email, phoneNumber, gender)
        userList.add(user)
        userAdapter.notifyDataSetChanged()

        // Clear fields
        etFullName.text.clear()
        etEmail.text.clear()
        etPhoneNumber.text.clear()
        rgGender.clearCheck()
        cbTerms.isChecked = false
    }
}
