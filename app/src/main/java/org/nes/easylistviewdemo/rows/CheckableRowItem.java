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
public class CheckableRowItem implements EasyListView.RowHolder{
    TextView titleTextView;
    CheckBox checkCheckBox;

    LayoutInflater layoutInflater;
    int layout;

    String title;
    boolean checked;

    public CheckableRowItem(Context context, int layout) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;

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
        View convertView = layoutInflater.inflate(layout, parent, false);
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
