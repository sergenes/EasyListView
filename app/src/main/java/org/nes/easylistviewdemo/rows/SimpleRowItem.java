package org.nes.easylistviewdemo.rows;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.nes.easylistview.EasyListView;
import org.nes.easylistviewdemo.R;

/**
 * Created by sergenes on 1/2/16.
 */
public class SimpleRowItem extends EasyListView.BaseEasyRow {
    TextView titleTextView;

    String title;

    public SimpleRowItem(Context context, int layout) {
        super(context, layout);
    }

    public SimpleRowItem setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public View inflate(ViewGroup parent) {
        View convertView = getInflatedView(parent);
        titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
        return convertView;
    }


    @Override
    public void update() {
        titleTextView.setText(title);
    }

}
