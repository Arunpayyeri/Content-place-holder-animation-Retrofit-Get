package com.example.signet.betaretetz;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.signet.betaretetz.POJO.EmpListPOJO;
import com.example.signet.betaretetz.POJO.Employee;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by signet on 09-Mar-18.
 */

public class Adapter extends BaseAdapter{
    List<Employee> employees;
    Context context;
    private static LayoutInflater inflater = null;

    public Adapter(Context mainActivity, List<Employee> e) {
        employees = e;
        context = mainActivity;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }




    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        View listItemView;
        listItemView = inflater.inflate(R.layout.list_item, null);

        //Set the name of company in the list item textview
        TextView name = (TextView) listItemView.findViewById(R.id.company_name);
        TextView dept_name=(TextView)listItemView.findViewById(R.id.dept_name);
        TextView txtdsgn=(TextView)listItemView.findViewById(R.id.txtdsgn);
        txtdsgn.setText(employees.get(position).getDesignation());
        dept_name.setText(employees.get(position).getDeptName());
        name.setText(employees.get(position).getEmpName());


        return listItemView;
    }

}
