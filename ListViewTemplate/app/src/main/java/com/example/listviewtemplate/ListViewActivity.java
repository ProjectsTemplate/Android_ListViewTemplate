package com.example.listviewtemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.listviewtemplate.Adapter.AdapterListView;
import com.example.listviewtemplate.Object.ItemInfo;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        String[] description = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };

        String [] date = new String[]{"1/4","1/4","1/4","1/4","1/4","1/4","1/4","1/4","1/4","1/4","1/4","1/4","1/4","1/4"
        ,"1/4","1/4","1/4","1/4","1/4","1/4","1/4","1/4","1/4"};
        int []id = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
        final ArrayList<ItemInfo> list = new ArrayList<ItemInfo>();

        for (int i = 0; i < id.length; ++i) {
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.setDate(date[i]);
            itemInfo.setId((id[i]));
            itemInfo.setDescription(description[i]);
            list.add(itemInfo);
        }
        SetDataToListView(list);
    }
    public void SetDataToListView(ArrayList<ItemInfo> itemInfolist){
        final ListView listview = (ListView) findViewById(R.id.listview);
        int itemviewId = android.R.layout.activity_list_item;
        final AdapterListView adapter = new AdapterListView(this, itemviewId, itemInfolist);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final ItemInfo item = (ItemInfo) parent.getItemAtPosition(position);

                view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                itemInfolist.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });
    }



}