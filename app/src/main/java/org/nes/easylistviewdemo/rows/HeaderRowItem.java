package org.nes.easylistviewdemo.rows;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.nes.easylistview.EasyListView;
import org.nes.easylistviewdemo.R;

/**
 * Created by sergenes on 1/3/16.
 */
public class HeaderRowItem extends EasyListView.BaseEasyHeader {
    TextView titleTextView;

    String title;

    public HeaderRowItem(Context context, int layout) {
        super(context, layout);
    }

    public HeaderRowItem setTitle(String title) {
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
