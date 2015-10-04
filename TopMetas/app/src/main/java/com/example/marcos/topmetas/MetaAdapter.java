package com.example.marcos.topmetas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;


public class MetaAdapter extends ArrayAdapter<Meta> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("H:m dd/MM/yyyy");
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
            holder.dataFinal = (TextView) row.findViewById(R.id.dataFinal);
            holder.progressBar = (ProgressBar) row.findViewById(R.id.progressBar);
            holder.porcentagem = (TextView) row.findViewById(R.id.porcentagem);

            row.setTag(holder);
        } else {
            holder = (MetaHolder) row.getTag();
        }

        Meta meta = metas[position];
        holder.dataFinal.setText(DATE_FORMAT.format(meta.dataFim));
        holder.progressBar.setProgress(meta.porcentagem);
        holder.porcentagem.setText(meta.porcentagem + "%");

        return row;
    }

    static class MetaHolder {
        TextView dataFinal;
        ProgressBar progressBar;
        TextView porcentagem;
    }
}
