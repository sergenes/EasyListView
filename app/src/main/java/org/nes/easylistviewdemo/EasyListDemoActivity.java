package org.nes.easylistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import org.nes.easylistview.EasyListView;
import org.nes.easylistviewdemo.rows.CheckableRowItem;
import org.nes.easylistviewdemo.rows.SimpleRowItem;

public class EasyListDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_list_demo);

        final EasyListView table = (EasyListView) findViewById(R.id.staticTable);

        SimpleRowItem item1 = new SimpleRowItem(this, R.layout.row_simple);
        SimpleRowItem item2 = new SimpleRowItem(this, R.layout.row_simple);
        CheckableRowItem item3 = new CheckableRowItem(this, R.layout.row_checkable);
        CheckableRowItem item4 = new CheckableRowItem(this, R.layout.row_checkable);
        CheckableRowItem item5 = new CheckableRowItem(this, R.layout.row_checkable);

        item1.setTitle("Test Row 1");
        item2.setTitle("Test Row 2");
        item3.setTitle("English").setChecked(true);
        item4.setTitle("Hebrew").setChecked(false);
        item5.setTitle("Russian").setChecked(false);

        table.getRowSource().add(item1);
        table.getRowSource().add(item2);
        table.getRowSource().add(item3);
        table.getRowSource().add(item4);
        table.getRowSource().add(item5);

        table.reloadData();

        table.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(EasyListView.RowHolder r:table.getRowSource()){
                    r.setDefaultValues();
                }

                table.getRowSource().get(position).onClick();
            }
        });
    }
}
