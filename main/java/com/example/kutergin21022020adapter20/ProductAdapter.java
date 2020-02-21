package com.example.kutergin21022020adapter20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    private LayoutInflater inflater;
    private int layout;
    private List<Product> productList;

    public ProductAdapter(Context context, int resource, List<Product> productList) {
        super(context, resource, productList);

        this.productList = productList;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView  =inflater.inflate(this.layout, parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Product product = productList.get(position);
        viewHolder.nameView.setText(product.getName());
        viewHolder.countView.setText(/*"" + product.getCount()*/ formatValue(product.getCount(), product.getUnit()));

        //  обработка нажатий
        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = product.getCount() + 1;
                product.setCount(count);
                viewHolder.countView.setText(formatValue(product.getCount(), product.getUnit()));
            }
        });

        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (product.getCount() > 0){
                    int count = product.getCount() - 1;
                    product.setCount(count);
                    viewHolder.countView.setText(formatValue(count, product.getUnit()));
                }
            }
        });


        return convertView;
    }

    private String formatValue (int count, String unit) {
        return String.valueOf(count) + " " + unit;
    }

    private class ViewHolder{
        final TextView nameView;
        final TextView countView;
        final Button addButton;
        final Button removeButton;

        ViewHolder(View view) {
            this.nameView = view.findViewById(R.id.nameView);
            this.countView = view.findViewById(R.id.countVeiw);
            this.addButton = view.findViewById(R.id.addButton);
            this.removeButton = view.findViewById(R.id.removeButton);
        }
    }
}
