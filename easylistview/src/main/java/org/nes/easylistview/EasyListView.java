package org.nes.easylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by sergenes on 1/2/16.
 */
public class EasyListView extends ListView {

    ArrayList<RowHolder> rowSource = new ArrayList<RowHolder>();

    public ArrayList<RowHolder> getRowSource() {
        return rowSource;
    }

    public void addRow(RowHolder row){
        rowSource.add(row);
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

        int getTag();
    }

    public static abstract class BaseEasyRow implements RowHolder {
        LayoutInflater layoutInflater;

        int layout;

        int tag = 0;

        public BaseEasyRow(Context context, int layout) {
            this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.layout = layout;
        }

        public View getInflatedView(ViewGroup parent) {
            View view = layoutInflater.inflate(layout, parent, false);
            view.setTag(tag);
            return view;
        }

        public void setTag(int tag) {
            this.tag = tag;
        }

        public int getTag() {
            return tag;
        }


        @Override
        public void setDefaultValues() {

        }

        @Override
        public void update() {

        }

        @Override
        public void onClick() {

        }

    }

    public static abstract class BaseEasyHeader extends BaseEasyRow {

        public BaseEasyHeader(Context context, int layout) {
            super(context, layout);
        }

        public View getInflatedView(ViewGroup parent) {
            View header = layoutInflater.inflate(layout, parent, false);
            //prevent onItemClick
            header.setClickable(true);
            return header;
        }
    }
}
