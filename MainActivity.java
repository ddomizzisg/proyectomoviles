package dispositivos_moviles_may_ago_2016.upvictoria.com.pg01_p03_cliente;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    public static TextView txtServer;
    private Button btnStop;
    private Button btnRestart;
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Las dos siguientes lineas son parche del proximo:
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        txtServer = (TextView) findViewById(R.id.txtServerResult);
        btnStop = (Button) findViewById(R.id.button);
        btnRestart = (Button) findViewById(R.id.button2);

        timer.schedule(new UpdateTask(),0,500);

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                timer.purge();
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer = new Timer();
                timer.schedule(new UpdateTask(),0,500);
            }
        });
    }
}
