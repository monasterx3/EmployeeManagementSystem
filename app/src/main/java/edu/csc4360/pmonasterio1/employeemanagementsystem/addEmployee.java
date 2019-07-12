package edu.csc4360.pmonasterio1.employeemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class addEmployee extends AppCompatActivity {

    private static final String EXTRA_EMP_ID = "com.androidtutorialpoint.empId";
    private static final String EXTRA_ADD_UPDATE = "com.androidtutorialpoint.add_update";


    private EditText nameEditText;
    private EditText positionEditText;
    private EditText emailEditText;
    private EditText phonenoEditText;
    private EditText salaryEditText;
    private Button addButton;
    private Employee newEmployee;
    private Employee oldEmployee;
    private String mode;
    private long empId;
    //private EmployeeOperations employeeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_update);
        newEmployee = new Employee();
        oldEmployee = new Employee();
        nameEditText = (EditText)findViewById(R.id.edit_text_name);
        positionEditText = (EditText)findViewById(R.id.edit_text_position);
        emailEditText = (EditText) findViewById(R.id.edit_text_email);
        phonenoEditText = (EditText)findViewById(R.id.edit_text_phone_no);
        salaryEditText = (EditText) findViewById(R.id.edit_text_email);
        addButton = (Button)findViewById(R.id.button_add_employee);
        //employeeData = new EmployeeOperations(this);
        //employeeData.open();


        mode = getIntent().getStringExtra(EXTRA_ADD_UPDATE);
        if(mode.equals("Update")){

            addButton.setText("Update Employee");
            empId = getIntent().getLongExtra(EXTRA_EMP_ID,0);

            initializeEmployee(empId);

        }


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mode.equals("Add")) {
                    newEmployee.setName(nameEditText.getText().toString());
                    newEmployee.setPosition(positionEditText.getText().toString());
                    newEmployee.setEmail(emailEditText.getText().toString());
                    newEmployee.setPhoneno(phonenoEditText.getText().toString());
                    newEmployee.setSalary(salaryEditText.getText().toString());

                   // employeeData.addEmployee(newEmployee);
                    Toast t = Toast.makeText(addEmployee.this, "Employee "+ newEmployee.getName() + "has been added successfully !", Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(addEmployee.this,MainActivity.class);
                    startActivity(i);
                }else {
                    oldEmployee.setName(nameEditText.getText().toString());
                    oldEmployee.setPosition(positionEditText.getText().toString());
                    oldEmployee.setEmail(emailEditText.getText().toString());
                    oldEmployee.setPhoneno(phonenoEditText.getText().toString());
                    oldEmployee.setSalary(salaryEditText.getText().toString());
                    //employeeData.updateEmployee(oldEmployee);
                    Toast t = Toast.makeText(addEmployee.this, "Employee "+ oldEmployee.getName() + " has been updated successfully !", Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(addEmployee.this,MainActivity.class);
                    startActivity(i);

                }


            }
        });


    }

    private void initializeEmployee(long empId) {
      //  oldEmployee = employeeData.getEmployee(empId);
        nameEditText.setText(oldEmployee.getName());


    }

}