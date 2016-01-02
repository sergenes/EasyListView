package org.nes.easylistviewdemo.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.nes.easylistview.EasyListView;
import org.nes.easylistviewdemo.R;

/**
 * Created by sergenes on 1/2/16.
 */
public class SimpleRowItem implements EasyListView.RowHolder{
    TextView titleTextView;

    LayoutInflater layoutInflater;

    int layout;

    String title;

    public SimpleRowItem(Context context, int layout) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
    }

    public SimpleRowItem setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public View inflate(ViewGroup parent) {
        View convertView = layoutInflater.inflate(layout, parent, false);
        titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
        return convertView;
    }

    @Override
    public void setDefaultValues() {

    }

    @Override
    public void update() {
        titleTextView.setText(title);
    }

    @Override
    public void onClick() {

    }

}
