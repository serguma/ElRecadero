package serguma.elrecadero;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by sergu on 02/04/2017.
 */

public class AdapterRecados extends RecyclerView.Adapter<RecadoViewHolder> {

    private ArrayList<Recado> recados;

    public AdapterRecados(ArrayList<Recado> recados) {
        this.recados = recados;
    }

    @Override
    public RecadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecadoViewHolder recadoViewHolder = null;

        //inflo la vista
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fila_recado, parent, false);
        recadoViewHolder = new RecadoViewHolder(view);

        return recadoViewHolder;
    }

    @Override
    public void onBindViewHolder(RecadoViewHolder holder, int position) {

        Recado recado = recados.get(position);
        holder.cargarDatosRecados(recado);

        //seteo un listener a la fila
        EscuchaBoton escuchaBoton = new EscuchaBoton(recados, position);
        holder.itemView.setOnClickListener(escuchaBoton);

        //Marco las filas seleccionadas
        if(recado.isCompletado()) {
            holder.itemView.setBackgroundColor(Color.rgb(102, 255, 168));
        }else{
            holder.itemView.setBackgroundColor(Color.rgb(255, 255, 255));
        }

    }

    @Override
    public int getItemCount() {
        return recados.size();
    }


}
