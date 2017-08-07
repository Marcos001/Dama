package save;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

/**
 * Created by marcos on 02/06/16.
 */
public class GerenciadorDados {

    Properties properties;
    File arquivo;

    private String diretorio = "/home/marcos/ProjetosIDEA/Novo/src/save/save.txt";

    public GerenciadorDados() {

        properties = new Properties();
        arquivo = new File(diretorio);
        if(arquivo.exists()){
            try {
                carregar();
                System.out.println("Arquivo carregado!");
            }catch (Exception erro){
                System.out.println("Não foi possivel carregar o arquivo!");
            }
        }
        else{
            System.out.println("Arquivo Não existe!");
        }
    }


    public void carregar() throws IOException{
        properties.load(new FileInputStream(arquivo));
    }

    public void salvar() throws FileNotFoundException, IOException {
        properties.store(new FileOutputStream(arquivo), null);
    }

    public void escrever(String propriety_name, int pontos){
        properties.setProperty(propriety_name,String.valueOf(pontos));
    }

    public int ler(String propriety_name){
        return Integer.valueOf(properties.getProperty(propriety_name));
    }


}
 //http://abrindoojogo.com.br/djj-13