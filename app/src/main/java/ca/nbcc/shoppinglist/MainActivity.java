/*
I decided to go crazy and implement something that will actually work well with any number of items and use real mvc, I hope.
My research gave me ListView class to implement lists and ArrayAdapter to controll listview. Since we have to use mpdel which is my Item class
I had to extend ArrayAdapter class to work with List<Itme>. I dont really need two classes ItemAdapter and ItemAdapterMain i could only use one, but
it would make it a little bit more complicated. I also had to make two different layouts since n one activity it's a button, and on another one
it's a TextView. To pass item object through intent I made it implement Parcelable. Because I did all that i did not have enough time to implement state saving. Sorry.
 */





package ca.nbcc.shoppinglist;

import android.app.ActionBar;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private ScrollView scroll;
    public static final int ITEM_REQUEST = 1;
    ConstraintLayout layout;
    ConstraintSet set = new ConstraintSet();
    ListView main_items_view;
    List<Item> items = new ArrayList<Item>();
    ItemAdapterMain adapter_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            items = savedInstanceState.getParcelableArrayList("ITEMS");
        }
        //Log.d("fuck", "Craate");
        setContentView(R.layout.activity_main);
        layout = (ConstraintLayout)findViewById(R.id.main_constraint);
        //scroll = findViewById(R.id.items);
        Log.d("MainActivityLog", "Open Shopping List");

        adapter_main = new ItemAdapterMain(this, items);

        main_items_view = findViewById(R.id.list_items_main);
        main_items_view.setAdapter(adapter_main);

        Log.d("ItemAdapterLog", "adapter bound");


    }
    public void openShoppingList(View view){
        Log.d("MainActivityLog", "Open Shopping List");
        Intent intent = new Intent(this, Items.class);
        startActivityForResult(intent, ITEM_REQUEST);
    }
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("IntentResult", "Intent recieved");
        if (requestCode == ITEM_REQUEST) {
            if (resultCode == RESULT_OK) {
                Log.d("IntentResult", "Intent OK");
                Item result = (Item) data.getParcelableExtra("ITEM");
                int test = data.getIntExtra("TEST", 10);

                addItem(result);

                Log.d("IntentResult", result.toString());
            }
        }
    }
    private void addItem(Item item){
        boolean repeat = false;
        for (Item i: items) {
            if(i.compare(item)) {
                i.addItems(1);
                repeat = true;
                break;
            }
        }
        if(!repeat)
            items.add(item);
        adapter_main.notifyDataSetChanged();
    }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(items.size() > 0){
            outState.putParcelableArrayList("ITEMS", (ArrayList<Item>)items);
        }
    }
}
