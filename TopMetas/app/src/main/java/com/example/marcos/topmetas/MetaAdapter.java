package com.example.marcos.topmetas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Giovanni on 04/10/2015.
 */
public class MetaAdapter extends ArrayAdapter<Meta> {

    Context context;
    int layoutResourceId;
    Meta metas[] = null;

    public MetaAdapter(Context context, int layoutResourceId, Meta[] metas) {
        super(context, layoutResourceId, metas);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.metas = metas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MetaHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new MetaHolder();
            holder.imgIcon = (ImageView) row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);

            row.setTag(holder);
        } else {
            holder = (MetaHolder) row.getTag();
        }


        Fotos fotos = metas[position];
        holder.txtTitle.setText(fotos.title);
        holder.imgIcon.setImageResource(fotos.icon);

        return row;
    }

    static class MetaHolder {
        ImageView imgIcon;
        TextView txtTitle;
    }
}
