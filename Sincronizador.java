package dispositivos_moviles_may_ago_2016.upvictoria.com.pg01_p03_cliente;

import android.os.AsyncTask;

/**
 * Created by domizzi on 25/06/16.
 */
public class Sincronizador extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        httpHandler handler = new httpHandler();
        return handler.post(params[0],params[1]);
    }

    @Override
    protected void onPostExecute(String result) {
        MainActivity.txtServer.setText(result);
    }
}
