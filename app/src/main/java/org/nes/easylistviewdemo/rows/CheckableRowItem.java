package org.nes.easylistviewdemo.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import org.nes.easylistview.EasyListView;
import org.nes.easylistviewdemo.R;

/**
 * Created by sergenes on 1/2/16.
 */
public class CheckableRowItem extends EasyListView.BaseEasyRow {
    TextView titleTextView;

    CheckBox checkCheckBox;

    String title;

    boolean checked;

    public CheckableRowItem(Context context, int layout) {
        super(context, layout);

    }

    public CheckableRowItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public CheckableRowItem setChecked(boolean checked) {
        this.checked = checked;
        return this;
    }

    @Override
    public View inflate(ViewGroup parent) {
        View convertView = getInflatedView(parent);
        titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
        checkCheckBox = (CheckBox) convertView.findViewById(R.id.checkCheckBox);
        return convertView;
    }

    @Override
    public void update() {
        titleTextView.setText(title);
        checkCheckBox.setChecked(checked);
    }

    @Override
    public void onClick() {
        checked = !checked;
        update();

    }

    @Override
    public void setDefaultValues() {
        checked = false;
        update();
    }
}
