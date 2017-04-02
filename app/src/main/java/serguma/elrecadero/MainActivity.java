package serguma.elrecadero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRecados adapterRecados;
    private ArrayList<Recado> recados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            //recupero los datos del bundle
            ArrayList<Recado> recados = (ArrayList<Recado>) savedInstanceState.getSerializable("losrecados");
            carga_datos(recados);
        } else {
            AsyncDescargaRecados asyncDescargaRecados = new AsyncDescargaRecados(this);
            asyncDescargaRecados.execute();
        }

    }

    public void carga_datos(ArrayList<Recado> recados) {

        this.recados = recados;
        //ordeno el listado
        Collections.sort(recados);

        //Utilizo un recycler, Asigno el adaptador

        recyclerView = (RecyclerView) findViewById(R.id.losrecados);
        adapterRecados = new AdapterRecados(recados);
        recyclerView.setAdapter(adapterRecados);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("losrecados", recados);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("losrecados", recados);
    }

    @Override
    public void onBackPressed() {
    }
}
