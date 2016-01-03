package org.nes.easylistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import org.nes.easylistview.EasyListView;
import org.nes.easylistviewdemo.rows.CheckableRowItem;
import org.nes.easylistviewdemo.rows.HeaderRowItem;
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

        HeaderRowItem header1 = new HeaderRowItem(this, R.layout.row_simple);
        header1.setTitle("Language");

        item3.setTitle("English").setChecked(true).setTag(1);
        item4.setTitle("Hebrew").setChecked(false).setTag(1);
        item5.setTitle("Russian").setChecked(false).setTag(1);

        HeaderRowItem header2 = new HeaderRowItem(this, R.layout.row_simple);
        header2.setTitle("Season");

        CheckableRowItem item6 = new CheckableRowItem(this, R.layout.row_checkable);
        CheckableRowItem item7 = new CheckableRowItem(this, R.layout.row_checkable);
        item6.setTitle("Winter").setChecked(true).setTag(2);
        item7.setTitle("Summer").setChecked(false).setTag(2);


        table.getRowSource().add(item1);
        table.getRowSource().add(item2);

        table.getRowSource().add(header1);

        table.getRowSource().add(item3);
        table.getRowSource().add(item4);
        table.getRowSource().add(item5);

        table.getRowSource().add(header2);

        table.getRowSource().add(item6);
        table.getRowSource().add(item7);

        table.reloadData();

        table.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (EasyListView.RowHolder r : table.getRowSource()) {
                    int tag = (int) view.getTag();
                    if (tag == r.getTag()) {
                        r.setDefaultValues();
                    }
                }

                table.getRowSource().get(position).onClick();
            }
        });
    }
}
