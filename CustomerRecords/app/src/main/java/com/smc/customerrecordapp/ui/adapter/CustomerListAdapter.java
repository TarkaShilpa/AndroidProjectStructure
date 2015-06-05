package com.smc.customerrecordapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smc.customerrecordapp.R;
import com.smc.customerrecordapp.dao.Customer;

import java.util.List;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.CustomerHolder> {

    private List<Customer> customers;
    private Context context;

    public CustomerListAdapter(Context context, List<Customer> customers) {

        this.context = context;
        this.customers = customers;
    }

    @Override
    public CustomerHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.list_item_customer, viewGroup, false);

        return new CustomerHolder(itemView);
    }

    public Customer getProperty(int index){
        return customers.get(index);
    }

    @Override
    public void onBindViewHolder(CustomerHolder customerHolder, int i) {

        Customer customer = customers.get(i);

        // Set tag
        //customerHolder.
        // Set data
        customerHolder.tvContactName.setText(customer.getContactName());
        customerHolder.tvCompanyName.setText(customer.getCompanyName());
        customerHolder.tvCountry.setText(customer.getCountry());
        customerHolder.tvPostalCode.setText(customer.getPostalCode());
        customerHolder.tvPhoneNumber.setText(customer.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public static class CustomerHolder extends RecyclerView.ViewHolder {
        protected TextView tvContactName;
        protected TextView tvCompanyName;
        protected TextView tvCountry;
        protected TextView tvPostalCode;
        protected TextView tvPhoneNumber;

        public CustomerHolder(View v){
            super(v);
            tvContactName = (TextView) v.findViewById(R.id.txtContactName);
            tvCompanyName = (TextView) v.findViewById(R.id.txtCompanyName);
            tvCountry = (TextView) v.findViewById(R.id.txtCountry);
            tvPostalCode = (TextView) v.findViewById(R.id.txtPostalCode);
            tvPhoneNumber = (TextView) v.findViewById(R.id.txtPhoneNumber);
        }
    }
}
