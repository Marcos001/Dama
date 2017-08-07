package vsAmiguinhoRede.com.auxiliar;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by marcos on 02/07/16.
 */
public class pingLocal {


    public boolean ping(String host){
        InetAddress in = null;

        try {

            // definimos o ip para termos o ping
            try {
                in = InetAddress.getByName(host);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

            // definindo o tempo de resposta
            try {
                if (in.isReachable(5000)) {
                    m("Disponivel em rede");
                    return true;
                } else {
                    m("Não Disponivel em rede");
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                m("Saida má esperada");
                return false;
            } //fim do primeiro try catch
        }
        catch (Exception erro){
            m("Valores mal informados");
            return false;
        }

    }

     public void m(String n){
         System.out.println(n);
     }



}
