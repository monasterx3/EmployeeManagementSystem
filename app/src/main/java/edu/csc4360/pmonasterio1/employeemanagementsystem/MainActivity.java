package edu.csc4360.pmonasterio1.employeemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private Button add_btn;
    private Button edit_btn;
    private Button delete_btn;
    private Button view_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_btn = (Button) findViewById(R.id.addEmployee);
        edit_btn = (Button) findViewById(R.id.editEmployee);
        delete_btn = (Button) findViewById(R.id.deleteEmployee);
        view_btn = (Button)findViewById(R.id.viewEmployee);

    add_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this,addEmployee.class);
          //  i.putExtra(EXTRA_ADD_UPDATE, "Add");
            startActivity(i);
        }
    });
        edit_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
        delete_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, EmployeeActivity.class);
            startActivity(i);
        }
    });

        view_btn.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EmployeeActivity.class);
                startActivity(i);
        }
    });

}
}
