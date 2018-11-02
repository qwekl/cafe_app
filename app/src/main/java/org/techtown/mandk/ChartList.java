package org.techtown.mandk;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LG on 2017-12-05.
 */

public class ChartList extends ArrayAdapter<Chart> {

    private Activity context;
    private List<Chart> chartList;

    public ChartList(Activity context, List<Chart> chartList){
        super(context,R.layout.list_layout,chartList);

        this.context = context;
        this.chartList = chartList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewMenuName = (TextView) listViewItem.findViewById(R.id.textViewMenuName);
        TextView textViewNum = (TextView) listViewItem.findViewById(R.id.textViewNum);
        TextView textViewPrice = (TextView) listViewItem.findViewById(R.id.textViewPrice);
        TextView textViewSize = (TextView) listViewItem.findViewById(R.id.textViewSize);

        Chart chart = chartList.get(position);

        textViewMenuName.setText(chart.getMenuName());
        textViewNum.setText(chart.getMenuNum());
        textViewPrice.setText(chart.getMenuPrice());
        textViewSize.setText(chart.getMenuSize());

        return listViewItem;
    }
}

