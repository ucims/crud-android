package www.heartfilia.com.madun.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import www.heartfilia.com.madun.MainActivity;
import www.heartfilia.com.madun.R;
import www.heartfilia.com.madun.model.DataModel;

/**
 * Created by heartfilia on 04/02/2018.
 */

public class AdapterData  extends RecyclerView.Adapter<AdapterData.HolderData>{
    private List<DataModel> mList;
    private Context ctx;

    public AdapterData (Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
       View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist,parent,false);
        HolderData holderData = new HolderData(layout);

        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        DataModel dm = mList.get(position);
        holder.id_berita.setText(dm.getId_berita());
        holder.tanggal.setText(dm.getTanggal());
        holder.isi.setText(dm.getIsi());
        holder.jenis.setText(dm.getJenis());
        holder.judul.setText(dm.getJudul());
        holder.dm = dm;

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView judul,tanggal,isi, jenis, id_berita;

        DataModel dm;

        public HolderData(View v){
            super(v);
            id_berita = (TextView)v.findViewById(R.id.tvId);
            tanggal = (TextView)v.findViewById(R.id.tvTanggal);
            isi = (TextView)v.findViewById(R.id.tvIsi);
            jenis = (TextView)v.findViewById(R.id.tvJenis);
            judul = (TextView)v.findViewById(R.id.tvJudul);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goEdit = new Intent(ctx, MainActivity.class);
                    goEdit.putExtra("id_berita", dm.getId_berita());
                    goEdit.putExtra("tanggal", dm.getTanggal());
                    goEdit.putExtra("isi", dm.getIsi());
                    goEdit.putExtra("jenis", dm.getJenis());
                    goEdit.putExtra("judul", dm.getJudul());
                    ctx.startActivity(goEdit);
                }
            });

        }

    }
}
