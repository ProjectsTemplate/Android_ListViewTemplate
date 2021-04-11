package com.example.listviewtemplate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewtemplate.Object.ItemInfo;
import com.example.listviewtemplate.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdapterListView extends ArrayAdapter<ItemInfo>{
        private Context context;
        ArrayList<ItemInfo> itemList = new ArrayList<>();
        public AdapterListView(Context context, int textViewResourceId, ArrayList<ItemInfo> objects) {
            super(context, textViewResourceId, objects);
            itemList = objects;
            this.context = context;
        }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_view_item, parent, false);
        TextView textView_date = (TextView)rowView.findViewById(R.id.date_number);
        TextView textView_description =(TextView)rowView.findViewById(R.id.video_info_in_date);
        textView_date.setText(this.itemList.get(position).getDate());
        textView_description.setText(this.itemList.get(position).getDescription());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Click to item view",Toast.LENGTH_SHORT).show();
            }
        });
        return rowView;
    }

    @Override
        public long getItemId(int position) {
            ItemInfo item = getItem(position);
            return item.getId();
        }
        public ItemInfo getItemInfo(int positon){
            return getItem(positon);
        }
        @Override
        public boolean hasStableIds() {
            return true;
        }

}
