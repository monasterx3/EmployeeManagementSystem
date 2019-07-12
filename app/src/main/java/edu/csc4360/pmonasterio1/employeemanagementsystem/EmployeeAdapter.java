package edu.csc4360.pmonasterio1.employeemanagementsystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    EmployeeActivity context;
    int listLayoutRes;
    List<Employee> employeeList;
    SQLiteDatabase mDatabase;

    public EmployeeAdapter(EmployeeActivity context, int listLayoutRes, List<Employee> employeeList) {
        super(context, listLayoutRes, employeeList);

        this.context = context;
        this.listLayoutRes = listLayoutRes;
        this.employeeList = employeeList;
        this.mDatabase = mDatabase;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(listLayoutRes, null, false);

        //getting the view elements of the list from the view
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewPosition = view.findViewById(R.id.textViewPosition);
        TextView textViewSalary = view.findViewById(R.id.textViewSalary);
        TextView textViewPhone = view.findViewById(R.id.textViewPhone);
        TextView textViewEmail = view.findViewById(R.id.textViewEmail);


        //getting employee of the specified position
        final Employee employee = employeeList.get(position);

        //adding values to the list item
        imageView.setImageDrawable(context.getResources().getDrawable(employee.getImage()));


        //adding data to views
        textViewName.setText(employee.getName());
        textViewPosition.setText(employee.getPosition());
        textViewSalary.setText(String.valueOf(employee.getSalary()));
        textViewPhone.setText(employee.getPhone());
        textViewEmail.setText(employee.getEmail());
        Button buttonDelete = view.findViewById(R.id.buttonDelete);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql = "DELETE FROM employees WHERE id = ?";
                        mDatabase.execSQL(sql, new Integer[]{employee.getId()});
                        //reloadEmployeesFromDatabase();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return view;
    }
}

