package ca.nbcc.shoppinglist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    private Context mContext;
    private AppCompatActivity itemsClass;
    private List<Item> list;

    public ItemAdapter(@NonNull Context context, List<Item> List, AppCompatActivity callingClass) {
        super(context, 0, List);
        mContext = context;
        list = List;
        itemsClass = callingClass;
        Log.d("ItemAdapterLog", "Created from " + itemsClass.toString() + " " + list.get(1));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("ItemAdapterLog", "getView Called");
        View listItem = convertView;

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.items_layout, parent, false);

        final Item item = list.get(position);




            Log.d("ItemAdapterLog", "Called from Items Activity");
            Button name = (Button) listItem.findViewById(R.id.button_item);
            name.setVisibility(View.VISIBLE);
            name.setText(item.getNameAndPrice());
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent();
                    intent.putExtra("ITEM", (Parcelable)item);
                    intent.putExtra("TEST", 1);
                    itemsClass.setResult(Activity.RESULT_OK, intent);

                    itemsClass.finish();
                }
            });


        return listItem;
    }

}