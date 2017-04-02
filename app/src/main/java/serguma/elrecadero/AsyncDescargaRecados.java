package serguma.elrecadero;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by sergu on 02/04/2017.
 */

public class AsyncDescargaRecados extends AsyncTask<Void, Void, ArrayList<Recado>> {

    private Context ctx;

    public AsyncDescargaRecados(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected ArrayList<Recado> doInBackground(Void... params) {

        ArrayList<Recado> recado = null;
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        int response = 0;

        try{

            url = new URL("http://elrecadero-ebtm.rhcloud.com/ObtenerListaRecados");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            response = httpURLConnection.getResponseCode();

            Gson gson = new Gson();
            Log.d(getClass().getCanonicalName(), "RESPONSE: " +response);

            if(response == httpURLConnection.HTTP_OK){

               inputStream = httpURLConnection.getInputStream();
                //le doy codificación para los caracteres con acentos
               inputStreamReader = new InputStreamReader(inputStream, "iso-8859-1");
                //obtengo los valores desde el json
               recado = gson.fromJson (inputStreamReader, new TypeToken<ArrayList<Recado>>() {}.getType());

                inputStream.close();

            }

        }catch (Throwable t){
            Log.d(getClass().getCanonicalName(), "ERROR: ", t);
        }finally {
            httpURLConnection.disconnect();
        }

        return recado;
    }

    @Override
    protected void onPostExecute(ArrayList<Recado> recados) {

        //en este caso no he puesto un cargando ya que es minima la espera, en principio
        MainActivity activity = (MainActivity) ctx;
        activity.carga_datos(recados);

        super.onPostExecute(recados);
    }
}
