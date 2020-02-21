package com.example.kutergin21022020adapter20;

import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

/*
public class MainActivity extends AppCompatActivity { //PRODUCT ADAPTER
    ListView listView;
    ArrayList<Product> productList =  new ArrayList<>();
    ProductAdapter adapter;
    TextView textView;
    EditText editText;
    ArrayList<Product> selectedProduct = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        if(productList.size() == 0) {
            setInit();
        }
        adapter = new ProductAdapter(this, R.layout.list_item, productList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray sp = listView.getCheckedItemPositions();
                String selectedItems = "";
                for (int i = 0; i < productList.size(); i++) {
                    if (sp.get(i)) {
                        selectedItems += productList.get(i).getName() + " ";
                    }
                }
                textView.setText("Выбрано" + selectedItems);

                Product itemcountr = (Product) adapter.getItem(position);
                if(listView.isItemChecked(position)){
                    selectedProduct.add(itemcountr);
                } else {
                    selectedProduct.remove(itemcountr);
                }


            }
        });

    }

    private void setInit() {
        productList.add(new Product("Картофель", "кг."));
        productList.add(new Product("Лук", "кг."));
        productList.add(new Product("Сало", "кг."));
        productList.add(new Product("Молоко", "л."));
        productList.add(new Product("Яйца", "шт."));
    }

    public void MyClickAdd(View view) {
        try {
            String[] productadd = editText.getText().toString().split(" ");
            if(!productadd[0].isEmpty() && !productList.contains(productadd[0])) {
                adapter.add(new Product(productadd[0], productadd[1]));
                editText.setText("");
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "Пустое поле ввода", Toast.LENGTH_SHORT).show();
        }
    }


    public void MyClickDel(View view) {

        for (int i = 0; i < selectedProduct.size(); i++) {
            adapter.remove(selectedProduct.get(i));
        }
        textView.setText("");
        listView.clearChoices();
        selectedProduct.clear();
        adapter.notifyDataSetChanged();
    }

}
*/

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Product> productlist = new ArrayList<>();
    ProductAdapter adapter;
    EditText editText;
    TextView textView;
    ArrayList<Product> selectedCountry = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listview);
        if (productlist.size() == 0) {
            setInit();
        }
        adapter = new ProductAdapter(this, R.layout.list_item, productlist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //State items = states.get(position);
                //textView.setText(items.getName());
                SparseBooleanArray sp = listView.getCheckedItemPositions();
                String selectedItems = "";
                for (int i = 0; i < productlist.size(); i++) {
                    if (sp.get(i)) {
                        selectedItems += productlist.get(i).getName() + ", ";
                    }
                }
                textView.setText("Выбрано: " + selectedItems);

                Product itemcountr = adapter.getItem(position);
                if (listView.isItemChecked(position)) {
                    selectedCountry.add(itemcountr);
                } else {
                    selectedCountry.remove(itemcountr);
                }


            }
        });
    }

    private void setInit() {
        productlist.add(new Product("Картофель", "кг"));
        productlist.add(new Product("Лук", "кг"));
        productlist.add(new Product("Молоко", "шт"));
        productlist.add(new Product("Яйца", "шт"));

    }
    public void MyClickDel(View view) {
        for (int i = 0; i < selectedCountry.size(); i++) {
            adapter.remove(selectedCountry.get(i));

        }
        textView.setText("");
        listView.clearChoices();
        selectedCountry.clear();
        adapter.notifyDataSetChanged();
    }

    public void MyClickAdd(View view) {
        try {
            String[] productadd = editText.getText().toString().split(" ");
            if (!productadd[0].isEmpty() && !productlist.contains(productadd)) {

                adapter.add(new Product(productadd[0], productadd[1]));
                editText.setText("");
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Пустое поле ввода", Toast.LENGTH_SHORT).show();
        }


    }
}



