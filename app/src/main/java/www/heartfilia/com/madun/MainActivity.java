package www.heartfilia.com.madun;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.heartfilia.com.madun.api.ApiRequestPengumuman;
import www.heartfilia.com.madun.api.RetroServer;
import www.heartfilia.com.madun.model.ResponsModel;

public class MainActivity extends AppCompatActivity {

    EditText tanggal,judul,isi;
    Spinner jenis;
    Button btnunggah, btnGo ;
    ImageButton btnUbah, btnHapus;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanggal = (EditText)findViewById(R.id.etTanggal);
        judul = (EditText)findViewById(R.id.etJudul);
        isi = (EditText)findViewById(R.id.etIsi);
        jenis = (Spinner)findViewById(R.id.spinner);

        btnunggah = (Button)findViewById(R.id.button);
        btnGo =(Button)findViewById(R.id.btnGoBerita);
        btnUbah = (ImageButton)findViewById(R.id.btnEdit);
        btnHapus = (ImageButton)findViewById(R.id.btnHapus);

        progressDialog = new ProgressDialog(this);

        Intent data = getIntent();
        final String idBerita = data.getStringExtra("id_berita");
        if (idBerita !=null){
            btnunggah.setVisibility(View.GONE);
            btnGo.setVisibility(View.GONE);
            btnUbah.setVisibility(View.VISIBLE);
            btnHapus.setVisibility(View.VISIBLE);
            tanggal.setText(data.getStringExtra("tanggal"));
            judul.setText(data.getStringExtra("judul"));
            isi.setText(data.getStringExtra("isi"));
            //jenis.setAdapter(data.getBundleExtra("jenis"));


        }

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.setMessage("Update ...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                ApiRequestPengumuman api = RetroServer.getClient().create(ApiRequestPengumuman.class);
                Call<ResponsModel> update = api.updateBerita(idBerita,tanggal.getText().toString(),isi.getText().toString(), jenis.getSelectedItem().toString(),judul.getText().toString());
                update.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        progressDialog.hide();
                        Toast.makeText(MainActivity.this, response.body().getPesan(), Toast.LENGTH_SHORT).show();
                        Log.d("Retro","Response");
                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);

                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        progressDialog.hide();
                        Log.d("Retro","onFailure");
                    }
                });
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Loading delete ...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                ApiRequestPengumuman api = RetroServer.getClient().create(ApiRequestPengumuman.class);
                Call<ResponsModel> del = api.deleteBerita(idBerita);
                del.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        progressDialog.hide();
                        Log.d("Retro", "onResponse");
                        Toast.makeText(MainActivity.this, response.body().getPesan(), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        progressDialog.hide();
                        Log.d("Retro","onFailure");
                    }
                });
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });

        btnunggah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.setMessage("Kirim data");
                progressDialog.setCancelable(false);
                progressDialog.show();

                String stanggal = tanggal.getText().toString();
                String sjudul = judul.getText().toString();
                String sisi = isi.getText().toString();
                String sjenis = jenis.getSelectedItem().toString();
                String sid_berita = "";

                ApiRequestPengumuman api = RetroServer.getClient().create(ApiRequestPengumuman.class);
                Call<ResponsModel> sendPengu = api.sendPengumuman(stanggal,sisi,sjenis,sjudul);

                sendPengu.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("RETRO","Response : " + response.body().toString());
                        String kode = response.body().getKode();
                        if (kode.equals("1")){
                            Toast.makeText(MainActivity.this,"Data Berhasil Disimpan", Toast.LENGTH_SHORT ).show();

                        }else{
                            Toast.makeText(MainActivity.this,"Data gagal Disimpan", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        Log.d("RETRO","Failure :" + "Gagal disimpan");
                    }
                });

            }
        });
    }

    public void setTanggal(View view){
        final java.util.Calendar c =  java.util.Calendar.getInstance();
        int thn = c.get(Calendar.YEAR);
        int bln = c.get(Calendar.MONTH);
        int tgl = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener(){
                    public void onDateSet(DatePicker view, int thn, int bln, int tgl){
                        tanggal.setText(thn + "-" + bln + "-" + tgl);
                    }
                },thn ,bln ,tgl );
        datePickerDialog.show();
    }
}
