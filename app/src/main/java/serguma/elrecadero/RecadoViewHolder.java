package serguma.elrecadero;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sergu on 02/04/2017.
 */

public class RecadoViewHolder extends RecyclerView.ViewHolder {

    private TextView cNombre;
    private TextView cFecha;
    private TextView cTelefono;
    private TextView cDireRegoge;
    private TextView cDireEntrega;
    private TextView cDescripcion;
    private TextView cHoraMax;


    public RecadoViewHolder(View itemView){
        super(itemView);

        cNombre = (TextView) itemView.findViewById(R.id.txtnombre);
        cFecha = (TextView) itemView.findViewById(R.id.txtfecha);
        cDescripcion = (TextView) itemView.findViewById(R.id.txtdescripcion);
        cDireEntrega = (TextView) itemView.findViewById(R.id.txtdentrega);
        cDireRegoge = (TextView) itemView.findViewById(R.id.txtdrecoge);
        cHoraMax = (TextView) itemView.findViewById(R.id.txthoramax);
        cTelefono = (TextView) itemView.findViewById(R.id.txttelefono);

    }

    public void cargarDatosRecados(Recado recado){

        this.cNombre.setText(recado.getNombre_cliente());
        this.cFecha.setText(recado.getFecha_hora().toString());
        this.cTelefono.setText(recado.getTelefono());
        this.cHoraMax.setText(recado.getFecha_hora_maxima().toString());
        this.cDireRegoge.setText(recado.getDireccion_recogida());
        this.cDireEntrega.setText(recado.getDireccion_entrega());
        this.cDescripcion.setText(recado.getDescripcion());

        Log.d(getClass().getCanonicalName(), "Realizado "+recado.isCompletado());

    }

}
