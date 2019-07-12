package edu.csc4360.pmonasterio1.employeemanagementsystem;


import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {

    List<Employee> employeeList;
    ListView listView;
    EmployeeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all);

        listView = (ListView) findViewById(R.id.listView);
        employeeList = new ArrayList<>();

        //creating the adapter
        EmployeeAdapter adapter = new EmployeeAdapter (this, R.layout.list_layout_employee, employeeList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
    }

}