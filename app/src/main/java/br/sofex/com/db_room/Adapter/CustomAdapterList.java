package br.sofex.com.db_room.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.sofex.com.db_room.R;

public class CustomAdapterList extends BaseAdapter {

    final List<Map.Entry<String, String>> mData;

    private final LayoutInflater inflater;

    public CustomAdapterList(Context context, Map<String, String> map) {
        inflater = LayoutInflater.from(context);
        mData = new ArrayList<>(map.entrySet());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<String, String> getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mData.get(position).getKey().hashCode();
    }

    public class ViewHolder {
        TextView Nome;
        TextView Endereco;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.Nome = convertView.findViewById(R.id.label);
            viewHolder.Endereco = convertView.findViewById(R.id.nome_label);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Map.Entry<String, String> item = getItem(position);
        Log.e("App1","Result Custom : "+position+" "+item.getKey()+" - "+item.getValue());

        viewHolder.Nome.setText(item.getKey());
        viewHolder.Endereco.setText(item.getValue());

        return convertView;
    }

 }