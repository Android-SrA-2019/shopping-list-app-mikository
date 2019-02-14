package ca.nbcc.shoppinglist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

import java.util.List;

public class ItemAdapterMain extends ArrayAdapter<Item> {
        private Context mContext;
        private List<Item> list;

        public ItemAdapterMain(@NonNull Context context, List<Item> List) {
            super(context, 0, List);
            mContext = context;
            list = List;

            Log.d("ItemAdapterLog", "creted Called");
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Log.d("ItemAdapterLog", "getView Called");
            View listItem = convertView;

            if (listItem == null)
                listItem = LayoutInflater.from(mContext).inflate(R.layout.items_layout_main, parent, false);

            final Item item = list.get(position);


                Log.d("ItemAdapterLog", "Called from Main Activity");
                TextView name = (TextView) listItem.findViewById(R.id.text_items);
                name.setVisibility(View.VISIBLE);
                name.setText(item.toString());


            return listItem;
        }

    }
