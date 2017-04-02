package serguma.elrecadero;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by sergu on 02/04/2017.
 */

public class EscuchaBoton implements View.OnClickListener {


    private ArrayList<Recado> recados;
    private int position;

    public EscuchaBoton(ArrayList<Recado> recados, int position) {
        this.recados = recados;
        this.position = position;
    }

    @Override
    public void onClick(View v) {

        final View vista = v;

        //Uso un alert para que el usuario elija entre marcar y no

        Log.d(getClass().getCanonicalName(), "Pulsado el item: "+ position + " " + recados.get(position).isCompletado());

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());
        alertDialog.setMessage("Marcar como completada");

        alertDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                recados.get(position).setCompletado(true);
                vista.setBackgroundColor(Color.rgb(102, 255, 168));
                dialog.cancel();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.create();
        alertDialog.show();

    }
}
