package ca.nbcc.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Items extends AppCompatActivity {

    List<Item> items = new ArrayList<Item>();
    ListView items_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        items.add(new Item("Eggs", 10, 1));
        items.add(new Item("Milk", 10, 1));
        items.add(new Item("Bacon", 10, 1));
        items.add(new Item("Cereal", 10, 1));
        items.add(new Item("Rice", 10, 1));
        items.add(new Item("Orange Juice", 10, 1));

        ItemAdapter adapter = new ItemAdapter(this, items, this);

        items_view = (ListView) findViewById(R.id.list_items);
        items_view.setAdapter(adapter);
        Log.d("ItemAdapterLog", "bound");
    }


}
