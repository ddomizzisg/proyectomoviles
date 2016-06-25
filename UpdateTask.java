package dispositivos_moviles_may_ago_2016.upvictoria.com.pg01_p03_cliente;

import android.util.Log;

import java.util.TimerTask;

/**
 * Created by domizzi on 25/06/16.
 */
public class UpdateTask extends TimerTask {

    @Override
    public void run() {
        Sincronizador s = new Sincronizador();
        s.execute("http://ddomizzi.me/moviles/proyecto/prueba.php","get");
    }
}
