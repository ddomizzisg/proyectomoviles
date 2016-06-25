package dispositivos_moviles_may_ago_2016.upvictoria.com.pg01_p03_cliente;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class httpHandler {
	String text;
	String line = "";

  //public String post(final String posturl, String ImagenC){
  public String post(final String posturl, String accion){

	  try {

		  

		  HttpClient httpclient = new DefaultHttpClient();
        //Creamos el objeto de HttpClient que nos permitira conectarnos mediante peticiones http
		  HttpPost httppost = new HttpPost(posturl);
        //El objeto HttpPost permite que enviemos una peticion de tipo POST a una URL especificada
		  //AÑADIR PARAMETROS
		  List<NameValuePair> params = new ArrayList<NameValuePair>();

          params.add(new BasicNameValuePair("accion",accion));


          //Una vez añadidos los parametros actualizamos la entidad de httppost, esto quiere decir en pocas palabras anexamos los parametros al objeto para que al enviarse al servidor envien los datos que hemos añadido
		  httppost.setEntity(new UrlEncodedFormEntity(params));

                  //Finalmente ejecutamos enviando la info al server
		  HttpResponse resp = httpclient.execute(httppost);
		  HttpEntity ent = resp.getEntity();//y obtenemos una respuesta

		  text = EntityUtils.toString(ent);

		  return text;

	  }
	  catch(Exception e) {return  e.getMessage();}

	}

}