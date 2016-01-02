package org.nes.easylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by sergenes on 1/2/16.
 */
public class EasyListView extends ListView {

    ArrayList<RowHolder> rowSource = new ArrayList();

    public ArrayList<RowHolder> getRowSource() {
        return rowSource;
    }

    public EasyListView(Context context) {
        super(context);
        init();
    }

    public EasyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EasyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setAdapter(new StaticTableAdapter());
    }

    public void reloadData() {
        ((StaticTableAdapter) getAdapter()).notifyDataSetChanged();
    }

    class StaticTableAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return rowSource.size();
        }

        @Override
        public Object getItem(int position) {
            return rowSource.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final RowHolder holder = rowSource.get(position);

            convertView = holder.inflate(parent);

            holder.update();

            return convertView;
        }
    }

    public interface RowHolder {
        View inflate(ViewGroup parent);

        void setDefaultValues();

        void update();

        void onClick();
    }
}
