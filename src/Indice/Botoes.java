package Indice;

/**
 * Created by marcos on 02/06/16.
 */


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botoes {

    private int cor1 = 255;
    private int cor2 = 5;

    private int jogador1 = 2;
    private int jogador2 = 3;

    private int atacante = 10;
    private int vitima = 5;
    private int casaFinal = 100;

    // atacante = verde
    private int a1 = 69,
            a2 = 231,
            a3 = 111;
    // vitima = amarelo
    private int v1 = 231,
            v2 = 229,
            v3 = 69;
    // casafinal = roxo
    private int cf1 = 193,
            cf2 = 70,
            cf3 = 224;


    ImageIcon bt_blue = new ImageIcon(getClass().getResource("../imagens/bolinhaa.png"));
    ImageIcon bt_red = new ImageIcon(getClass().getResource("../imagens/bolinhav.png"));

    ImageIcon bt_blue_rainha = new ImageIcon(getClass().getResource("../imagens/bolinhaa_rainha.png"));
    ImageIcon bt_red_rainha = new ImageIcon(getClass().getResource("../imagens/bolinhav_rainha.png"));

    private boolean []vetorcf = new boolean[32];

   public JButton bt1 = new JButton(),
            bt2 = new JButton(),
            bt3 = new JButton(),
            bt4 = new JButton(),
            bt5 = new JButton(),
            bt6 = new JButton(),
            bt7 = new JButton(),
            bt8 = new JButton(),
            bt9 = new JButton(),
            bt10 = new JButton(),

    bt11 = new JButton(),
            bt12 = new JButton(),
            bt13 = new JButton(),
            bt14 = new JButton(),
            bt15 = new JButton(),
            bt16 = new JButton(),
            bt17 = new JButton(),
            bt18 = new JButton(),
            bt19 = new JButton(),
            bt20 = new JButton(),


    bt21 = new JButton(),
            bt22 = new JButton(),
            bt23 = new JButton(),
            bt24 = new JButton(),
            bt25 = new JButton(),
            bt26 = new JButton(),
            bt27 = new JButton(),
            bt28 = new JButton(),
            bt29 = new JButton(),
            bt30 = new JButton(),

    bt31 = new JButton(),
            bt32 = new JButton(),
            bt33 = new JButton(),
            bt34 = new JButton(),
            bt35 = new JButton(),
            bt36 = new JButton(),
            bt37 = new JButton(),
            bt38 = new JButton(),
            bt39 = new JButton(),
            bt40 = new JButton(),

    bt41 = new JButton(),
            bt42 = new JButton(),
            bt43 = new JButton(),
            bt44 = new JButton(),
            bt45 = new JButton(),
            bt46 = new JButton(),
            bt47 = new JButton(),
            bt48 = new JButton(),
            bt49 = new JButton(),
            bt50 = new JButton(),


    bt51 = new JButton(),
            bt52 = new JButton(),
            bt53 = new JButton(),
            bt54 = new JButton(),
            bt55 = new JButton(),
            bt56 = new JButton(),
            bt57 = new JButton(),
            bt58 = new JButton(),
            bt59 = new JButton(),
            bt60 = new JButton(),

    bt61 = new JButton(),
            bt62 = new JButton(),
            bt63 = new JButton(),
            bt64 = new JButton();

    public Botoes(){

        tingit_brancas();
        tingir_pretas();
        por_pecas();

    }
    public boolean getVetor(int indice){
        return vetorcf[indice];
    }

    public void zerarVetor(){
        for(int i =0;i<32;i++){
            vetorcf[i] = false;
        }
    }


    public void tingit_brancas(){
        bt2.setBackground(new Color(cor1,cor1,cor1));
        bt4.setBackground(new Color(cor1,cor1,cor1));
        bt6.setBackground(new Color(cor1,cor1,cor1));
        bt8.setBackground(new Color(cor1,cor1,cor1));

        bt9.setBackground(new Color(cor1,cor1,cor1));
        bt11.setBackground(new Color(cor1,cor1,cor1));
        bt13.setBackground(new Color(cor1,cor1,cor1));
        bt15.setBackground(new Color(cor1,cor1,cor1));

        bt18.setBackground(new Color(cor1,cor1,cor1));
        bt20.setBackground(new Color(cor1,cor1,cor1));
        bt22.setBackground(new Color(cor1,cor1,cor1));
        bt24.setBackground(new Color(cor1,cor1,cor1));

        bt25.setBackground(new Color(cor1,cor1,cor1));
        bt27.setBackground(new Color(cor1,cor1,cor1));
        bt29.setBackground(new Color(cor1,cor1,cor1));
        bt31.setBackground(new Color(cor1,cor1,cor1));

        bt34.setBackground(new Color(cor1,cor1,cor1));
        bt36.setBackground(new Color(cor1,cor1,cor1));
        bt38.setBackground(new Color(cor1,cor1,cor1));
        bt41.setBackground(new Color(cor1,cor1,cor1));

        bt40.setBackground(new Color(cor1,cor1,cor1));
        bt43.setBackground(new Color(cor1,cor1,cor1));
        bt45.setBackground(new Color(cor1,cor1,cor1));
        bt47.setBackground(new Color(cor1,cor1,cor1));

        bt50.setBackground(new Color(cor1,cor1,cor1));
        bt52.setBackground(new Color(cor1,cor1,cor1));
        bt54.setBackground(new Color(cor1,cor1,cor1));
        bt56.setBackground(new Color(cor1,cor1,cor1));

        bt57.setBackground(new Color(cor1,cor1,cor1));
        bt59.setBackground(new Color(cor1,cor1,cor1));
        bt61.setBackground(new Color(cor1,cor1,cor1));
        bt63.setBackground(new Color(cor1,cor1,cor1));
    }

    public void tingir_pretas(){
        bt1.setBackground(new Color(cor2,cor2,cor2));
        bt3.setBackground(new Color(cor2,cor2,cor2));
        bt5.setBackground(new Color(cor2,cor2,cor2));
        bt7.setBackground(new Color(cor2,cor2,cor2));

        bt10.setBackground(new Color(cor2,cor2,cor2));
        bt12.setBackground(new Color(cor2,cor2,cor2));
        bt14.setBackground(new Color(cor2,cor2,cor2));
        bt16.setBackground(new Color(cor2,cor2,cor2));

        bt17.setBackground(new Color(cor2,cor2,cor2));
        bt19.setBackground(new Color(cor2,cor2,cor2));
        bt21.setBackground(new Color(cor2,cor2,cor2));
        bt23.setBackground(new Color(cor2,cor2,cor2));

        bt26.setBackground(new Color(cor2,cor2,cor2));
        bt28.setBackground(new Color(cor2,cor2,cor2));
        bt30.setBackground(new Color(cor2,cor2,cor2));
        bt32.setBackground(new Color(cor2,cor2,cor2));

        //************************************

        bt33.setBackground(new Color(cor2,cor2,cor2));
        bt35.setBackground(new Color(cor2,cor2,cor2));
        bt37.setBackground(new Color(cor2,cor2,cor2));
        bt39.setBackground(new Color(cor2,cor2,cor2));

        bt42.setBackground(new Color(cor2,cor2,cor2));
        bt44.setBackground(new Color(cor2,cor2,cor2));
        bt46.setBackground(new Color(cor2,cor2,cor2));
        bt48.setBackground(new Color(cor2,cor2,cor2));

        bt49.setBackground(new Color(cor2,cor2,cor2));
        bt51.setBackground(new Color(cor2,cor2,cor2));
        bt53.setBackground(new Color(cor2,cor2,cor2));
        bt55.setBackground(new Color(cor2,cor2,cor2));


        bt58.setBackground(new Color(cor2,cor2,cor2));
        bt60.setBackground(new Color(cor2,cor2,cor2));
        bt62.setBackground(new Color(cor2,cor2,cor2));
        bt64.setBackground(new Color(cor2,cor2,cor2));
    }

    public void por_pecas(){
        bt1.setIcon(bt_blue);
        bt3.setIcon(bt_blue);
        bt5.setIcon(bt_blue);
        bt7.setIcon(bt_blue);

        bt10.setIcon(bt_blue);
        bt12.setIcon(bt_blue);
        bt14.setIcon(bt_blue);
        bt16.setIcon(bt_blue);

        bt17.setIcon(bt_blue);
        bt19.setIcon(bt_blue);
        bt21.setIcon(bt_blue);
        bt23.setIcon(bt_blue);

        //vermelhos

        bt42.setIcon(bt_red);
        bt44.setIcon(bt_red);
        bt46.setIcon(bt_red);
        bt48.setIcon(bt_red);

        bt49.setIcon(bt_red);
        bt51.setIcon(bt_red);
        bt53.setIcon(bt_red);
        bt55.setIcon(bt_red);

        bt58.setIcon(bt_red);
        bt60.setIcon(bt_red);
        bt62.setIcon(bt_red);
        bt64.setIcon(bt_red);

    }

    public int procurar_peca(int linha,int coluna){
//linha 0
        int n = 0;

        if(linha == 0 && coluna == 0){
            n = 1;
        }
        if(linha == 0 && coluna == 2){
            n = 3;
        }
        if(linha == 0 && coluna == 4){
            n = 5;
        }
        if(linha == 0 && coluna == 6){
            n = 7;
        }
//linha 1
        if(linha == 1 && coluna == 1){
            n = 10;
        }
        if(linha == 1 && coluna == 3){
            n = 12;
        }
        if(linha == 1 && coluna == 5){
            n = 14;
        }
        if(linha == 1 && coluna == 7){
            n = 16;
        }
//linha 2
        if(linha == 2 && coluna == 0){
            n = 17;
        }
        if(linha == 2 && coluna == 2){
            n =19;
        }
        if(linha == 2 && coluna == 4){
            n = 21;
        }
        if(linha == 2 && coluna == 6){
            n = 23;
        }
//linha 3
        if(linha == 3 && coluna == 1){
            n = 26;
        }
        if(linha == 3 && coluna == 3){
            n = 28;
        }
        if(linha == 3 && coluna == 5){
            n = 30;
        }
        if(linha == 3 && coluna == 7){
            n = 32;
        }
//linha 4
        if(linha == 4 && coluna == 0){
            n = 33;
        }
        if(linha == 4 && coluna == 2){
            n = 35;
        }
        if(linha == 4 && coluna == 4){
            n = 37;
        }
        if(linha == 4 && coluna == 6){
            n = 39;
        }
//linha 5
        if(linha == 5 && coluna == 1){
            n = 42;
        }
        if(linha == 5 && coluna == 3){
            n = 44;
        }
        if(linha == 5 && coluna == 5){
            n = 46;
        }
        if(linha == 5 && coluna == 7){
            n = 48;
        }
//linha 6
        if(linha == 6 && coluna == 0){
            n = 49;
        }
        if(linha == 6 && coluna == 2){
            n = 51;
        }
        if(linha == 6 && coluna == 4){
            n = 53;
        }
        if(linha == 6 && coluna == 6){
            n = 55;
        }
//linha 7
        if(linha == 7 && coluna == 1){
            n = 58;
        }
        if(linha == 7 && coluna == 3){
            n = 60;
        }
        if(linha == 7 && coluna == 5){
            n = 62;
        }
        if(linha == 7 && coluna == 7){
            n = 64;
        }
        return n;
    }

    public void setarIcone(int id,int jogador){

        if(jogador == jogador1) {

            switch (id) {
                case 1:
                    bt1.setIcon(bt_blue);
                    break;
                case 3:
                    bt3.setIcon(bt_blue);
                    break;
                case 5:
                    bt5.setIcon(bt_blue);
                    break;
                case 7:
                    bt7.setIcon(bt_blue);
                    break;

                //linha 1
                case 10:
                    bt10.setIcon(bt_blue);
                    break;
                case 12:
                    bt12.setIcon(bt_blue);
                    break;
                case 14:
                    bt14.setIcon(bt_blue);
                    break;
                case 16:
                    bt16.setIcon(bt_blue);
                    break;

                //linha 2
                case 17:
                    bt17.setIcon(bt_blue);
                    break;
                case 19:
                    bt19.setIcon(bt_blue);
                    break;
                case 21:
                    bt21.setIcon(bt_blue);
                    break;
                case 23:
                    bt23.setIcon(bt_blue);
                    break;

                //linha 3
                case 26:
                    bt26.setIcon(bt_blue);
                    break;
                case 28:
                    bt28.setIcon(bt_blue);
                    break;
                case 30:
                    bt30.setIcon(bt_blue);
                    break;
                case 32:
                    bt32.setIcon(bt_blue);
                    break;

                //linha 4
                case 33:
                    bt33.setIcon(bt_blue);
                    break;
                case 35:
                    bt35.setIcon(bt_blue);
                    break;
                case 37:
                    bt37.setIcon(bt_blue);
                    break;
                case 39:
                    bt39.setIcon(bt_blue);
                    break;

                //linha 5
                case 42:
                    bt42.setIcon(bt_blue);
                    break;
                case 44:
                    bt44.setIcon(bt_blue);
                    break;
                case 46:
                    bt46.setIcon(bt_blue);
                    break;
                case 48:
                    bt48.setIcon(bt_blue);
                    break;

                //linha 6
                case 49:
                    bt49.setIcon(bt_blue);
                    break;
                case 51:
                    bt51.setIcon(bt_blue);
                    break;
                case 53:
                    bt53.setIcon(bt_blue);
                    break;
                case 55:
                    bt55.setIcon(bt_blue);
                    break;

                //linha 7
                case 58:
                    bt58.setIcon(bt_blue);
                    break;
                case 60:
                    bt60.setIcon(bt_blue);
                    break;
                case 62:
                    bt62.setIcon(bt_blue);
                    break;
                case 64:
                    bt64.setIcon(bt_blue);
                    break;
            }
        }else if(jogador == jogador2){
            switch (id) {
                case 1:
                    bt1.setIcon(bt_red);
                    break;
                case 3:
                    bt3.setIcon(bt_red);
                    break;
                case 5:
                    bt5.setIcon(bt_red);
                    break;
                case 7:
                    bt7.setIcon(bt_red);
                    break;

                //linha 1
                case 10:
                    bt10.setIcon(bt_red);
                    break;
                case 12:
                    bt12.setIcon(bt_red);
                    break;
                case 14:
                    bt14.setIcon(bt_red);
                    break;
                case 16:
                    bt16.setIcon(bt_red);
                    break;

                //linha 2
                case 17:
                    bt17.setIcon(bt_red);
                    break;
                case 19:
                    bt19.setIcon(bt_red);
                    break;
                case 21:
                    bt21.setIcon(bt_red);
                    break;
                case 23:
                    bt23.setIcon(bt_red);
                    break;

                //linha 3
                case 26:
                    bt26.setIcon(bt_red);
                    break;
                case 28:
                    bt28.setIcon(bt_red);
                    break;
                case 30:
                    bt30.setIcon(bt_red);
                    break;
                case 32:
                    bt32.setIcon(bt_red);
                    break;

                //linha 4
                case 33:
                    bt33.setIcon(bt_red);
                    break;
                case 35:
                    bt35.setIcon(bt_red);
                    break;
                case 37:
                    bt37.setIcon(bt_red);
                    break;
                case 39:
                    bt39.setIcon(bt_red);
                    break;

                //linha 5
                case 42:
                    bt42.setIcon(bt_red);
                    break;
                case 44:
                    bt44.setIcon(bt_red);
                    break;
                case 46:
                    bt46.setIcon(bt_red);
                    break;
                case 48:
                    bt48.setIcon(bt_red);
                    break;

                //linha 6
                case 49:
                    bt49.setIcon(bt_red);
                    break;
                case 51:
                    bt51.setIcon(bt_red);
                    break;
                case 53:
                    bt53.setIcon(bt_red);
                    break;
                case 55:
                    bt55.setIcon(bt_red);
                    break;

                //linha 7
                case 58:
                    bt58.setIcon(bt_red);
                    break;
                case 60:
                    bt60.setIcon(bt_red);
                    break;
                case 62:
                    bt62.setIcon(bt_red);
                    break;
                case 64:
                    bt64.setIcon(bt_red);
                    break;
            }
        }
        else{
            System.out.println("Saida nao esperada");
        }
    }

    public void setarIcone_rainha(int id,int jogador){

        if(jogador == 20) {

            switch (id) {
                case 1:
                    bt1.setIcon(bt_blue_rainha);
                    break;
                case 3:
                    bt3.setIcon(bt_blue_rainha);
                    break;
                case 5:
                    bt5.setIcon(bt_blue_rainha);
                    break;
                case 7:
                    bt7.setIcon(bt_blue_rainha);
                    break;

                //linha 1
                case 10:
                    bt10.setIcon(bt_blue_rainha);
                    break;
                case 12:
                    bt12.setIcon(bt_blue_rainha);
                    break;
                case 14:
                    bt14.setIcon(bt_blue_rainha);
                    break;
                case 16:
                    bt16.setIcon(bt_blue_rainha);
                    break;

                //linha 2
                case 17:
                    bt17.setIcon(bt_blue_rainha);
                    break;
                case 19:
                    bt19.setIcon(bt_blue_rainha);
                    break;
                case 21:
                    bt21.setIcon(bt_blue_rainha);
                    break;
                case 23:
                    bt23.setIcon(bt_blue_rainha);
                    break;

                //linha 3
                case 26:
                    bt26.setIcon(bt_blue_rainha);
                    break;
                case 28:
                    bt28.setIcon(bt_blue_rainha);
                    break;
                case 30:
                    bt30.setIcon(bt_blue_rainha);
                    break;
                case 32:
                    bt32.setIcon(bt_blue_rainha);
                    break;

                //linha 4
                case 33:
                    bt33.setIcon(bt_blue_rainha);
                    break;
                case 35:
                    bt35.setIcon(bt_blue_rainha);
                    break;
                case 37:
                    bt37.setIcon(bt_blue_rainha);
                    break;
                case 39:
                    bt39.setIcon(bt_blue_rainha);
                    break;

                //linha 5
                case 42:
                    bt42.setIcon(bt_blue_rainha);
                    break;
                case 44:
                    bt44.setIcon(bt_blue_rainha);
                    break;
                case 46:
                    bt46.setIcon(bt_blue_rainha);
                    break;
                case 48:
                    bt48.setIcon(bt_blue_rainha);
                    break;

                //linha 6
                case 49:
                    bt49.setIcon(bt_blue_rainha);
                    break;
                case 51:
                    bt51.setIcon(bt_blue_rainha);
                    break;
                case 53:
                    bt53.setIcon(bt_blue_rainha);
                    break;
                case 55:
                    bt55.setIcon(bt_blue_rainha);
                    break;

                //linha 7
                case 58:
                    bt58.setIcon(bt_blue_rainha);
                    break;
                case 60:
                    bt60.setIcon(bt_blue_rainha);
                    break;
                case 62:
                    bt62.setIcon(bt_blue_rainha);
                    break;
                case 64:
                    bt64.setIcon(bt_blue_rainha);
                    break;
            }
        }else if(jogador == 30){
            switch (id) {
                case 1:
                    bt1.setIcon(bt_red_rainha);
                    break;
                case 3:
                    bt3.setIcon(bt_red_rainha);
                    break;
                case 5:
                    bt5.setIcon(bt_red_rainha);
                    break;
                case 7:
                    bt7.setIcon(bt_red_rainha);
                    break;

                //linha 1
                case 10:
                    bt10.setIcon(bt_red_rainha);
                    break;
                case 12:
                    bt12.setIcon(bt_red_rainha);
                    break;
                case 14:
                    bt14.setIcon(bt_red_rainha);
                    break;
                case 16:
                    bt16.setIcon(bt_red_rainha);
                    break;

                //linha 2
                case 17:
                    bt17.setIcon(bt_red_rainha);
                    break;
                case 19:
                    bt19.setIcon(bt_red_rainha);
                    break;
                case 21:
                    bt21.setIcon(bt_red_rainha);
                    break;
                case 23:
                    bt23.setIcon(bt_red_rainha);
                    break;

                //linha 3
                case 26:
                    bt26.setIcon(bt_red_rainha);
                    break;
                case 28:
                    bt28.setIcon(bt_red_rainha);
                    break;
                case 30:
                    bt30.setIcon(bt_red_rainha);
                    break;
                case 32:
                    bt32.setIcon(bt_red_rainha);
                    break;

                //linha 4
                case 33:
                    bt33.setIcon(bt_red_rainha);
                    break;
                case 35:
                    bt35.setIcon(bt_red_rainha);
                    break;
                case 37:
                    bt37.setIcon(bt_red_rainha);
                    break;
                case 39:
                    bt39.setIcon(bt_red_rainha);
                    break;

                //linha 5
                case 42:
                    bt42.setIcon(bt_red_rainha);
                    break;
                case 44:
                    bt44.setIcon(bt_red_rainha);
                    break;
                case 46:
                    bt46.setIcon(bt_red_rainha);
                    break;
                case 48:
                    bt48.setIcon(bt_red_rainha);
                    break;

                //linha 6
                case 49:
                    bt49.setIcon(bt_red_rainha);
                    break;
                case 51:
                    bt51.setIcon(bt_red_rainha);
                    break;
                case 53:
                    bt53.setIcon(bt_red_rainha);
                    break;
                case 55:
                    bt55.setIcon(bt_red_rainha);
                    break;

                //linha 7
                case 58:
                    bt58.setIcon(bt_red_rainha);
                    break;
                case 60:
                    bt60.setIcon(bt_red_rainha);
                    break;
                case 62:
                    bt62.setIcon(bt_red_rainha);
                    break;
                case 64:
                    bt64.setIcon(bt_red_rainha);
                    break;
            }
        }
        else{
            System.out.println("Saida nao esperada");
        }
    }

    public void removerIcone(int id) {


        switch (id) {
            case 1:
                bt1.setIcon(null);
                break;
            case 3:
                bt3.setIcon(null);
                break;
            case 5:
                bt5.setIcon(null);
                break;
            case 7:
                bt7.setIcon(null);
                break;

            //linha 1
            case 10:
                bt10.setIcon(null);
                break;
            case 12:
                bt12.setIcon(null);
                break;
            case 14:
                bt14.setIcon(null);
                break;
            case 16:
                bt16.setIcon(null);
                break;

            //linha 2
            case 17:
                bt17.setIcon(null);
                break;
            case 19:
                bt19.setIcon(null);
                break;
            case 21:
                bt21.setIcon(null);
                break;
            case 23:
                bt23.setIcon(null);
                break;

            //linha 3
            case 26:
                bt26.setIcon(null);
                break;
            case 28:
                bt28.setIcon(null);
                break;
            case 30:
                bt30.setIcon(null);
                break;
            case 32:
                bt32.setIcon(null);
                break;

            //linha 4
            case 33:
                bt33.setIcon(null);
                break;
            case 35:
                bt35.setIcon(null);
                break;
            case 37:
                bt37.setIcon(null);
                break;
            case 39:
                bt39.setIcon(null);
                break;

            //linha 5
            case 42:
                bt42.setIcon(null);
                break;
            case 44:
                bt44.setIcon(null);
                break;
            case 46:
                bt46.setIcon(null);
                break;
            case 48:
                bt48.setIcon(null);
                break;

            //linha 6
            case 49:
                bt49.setIcon(null);
                break;
            case 51:
                bt51.setIcon(null);
                break;
            case 53:
                bt53.setIcon(null);
                break;
            case 55:
                bt55.setIcon(null);
                break;

            //linha 7
            case 58:
                bt58.setIcon(null);
                break;
            case 60:
                bt60.setIcon(null);
                break;
            case 62:
                bt62.setIcon(null);
                break;
            case 64:
                bt64.setIcon(null);
                break;

        }
    }

    //Button 1 fila

    public void button1(int sujeito){
        if(sujeito == atacante){
            bt1.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt1.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt1.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[0] = true;
        }
    } //ok
    public void button3(int sujeito){
        if(sujeito == atacante){
            bt3.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt3.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt3.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[1] = true;
        }
    } //ok

    public void button5(int sujeito){
        if(sujeito == atacante){
            bt5.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt5.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt5.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[2] = true;
        }
    } //ok
    public void button7(int sujeito){
        if(sujeito == atacante){
            bt7.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt7.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt7.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[3] = true;
        }
    } //ok

    //segunda fila de botoes ok

    public void button10(int sujeito){
        if(sujeito == atacante){
            bt10.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt10.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt10.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[4] = true;
        }
    } //ok
    public void button12(int sujeito){
        if(sujeito == atacante){
            bt12.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt12.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt12.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[5] = true;
        }
    } //ok

    public void button14(int sujeito){
        if(sujeito == atacante){
            bt14.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt14.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt14.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[6] = true;
        }
    } //ok
    public void button16(int sujeito){
        if(sujeito == atacante){
            bt16.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt16.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt16.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[7] = true;
        }
    } //ok

    //terceira fila de botoes ok

    public void button17(int sujeito){
        if(sujeito == atacante){
            bt17.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt17.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt17.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[8] = true;
        }
    } //ok
    public void button19(int sujeito){
        if(sujeito == atacante){
            bt19.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt19.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt19.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[9] = true;
        }
    } //ok

    public void button21(int sujeito){
        if(sujeito == atacante){
            bt21.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt21.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt21.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[10] = true;
        }
    } //ok
    public void button23(int sujeito){
        if(sujeito == atacante){
            bt23.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt23.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt23.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[11] = true;
        }
    } //ok

    //quarta fila de botoes ok

    public void button26(int sujeito){
        if(sujeito == atacante){
            bt26.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt26.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt26.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[12] = true;
        }
    } //ok
    public void button28(int sujeito){
        if(sujeito == atacante){
            bt28.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt28.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt28.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[13] = true;
        }
    } //ok

    public void button30(int sujeito){
        if(sujeito == atacante){
            bt30.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt30.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt30.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[14] = true;
        }
    } //ok
    public void button32(int sujeito){
        if(sujeito == atacante){
            bt32.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt32.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt32.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[15] = true;
        }
    } //ok

    //5 - quinta fila de botoes ok

    public void button33(int sujeito){
        if(sujeito == atacante){
            bt33.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt33.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt33.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[16] = true;
        }
    } //ok
    public void button35(int sujeito){
        if(sujeito == atacante){
            bt35.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt35.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt35.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[17] = true;
        }
    } //ok

    public void button37(int sujeito){
        if(sujeito == atacante){
            bt37.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt37.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt37.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[18] = true;
        }
    } //ok
    public void button39(int sujeito){
        if(sujeito == atacante){
            bt39.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt39.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt39.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[19] = true;
        }
    } //ok

    //6 - sexta fila de botoes ok

    public void button42(int sujeito){
        if(sujeito == atacante){
            bt42.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt42.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt42.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[20] = true;
        }
    } //ok
    public void button44(int sujeito){
        if(sujeito == atacante){
            bt44.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt44.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt44.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[21] = true;
        }
    } //ok

    public void button46(int sujeito){
        if(sujeito == atacante){
            bt46.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt46.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt46.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[22] = true;
        }
    } //ok
    public void button48(int sujeito){
        if(sujeito == atacante){
            bt48.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt48.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt48.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[23] = true;
        }
    } //ok

    //7 - setima fila de botoes ok

    public void button49(int sujeito){
        if(sujeito == atacante){
            bt49.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt49.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt49.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[24] = true;
        }
    } //ok
    public void button51(int sujeito){
        if(sujeito == atacante){
            bt51.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt51.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt51.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[25] = true;
        }
    } //ok

    public void button53(int sujeito){
        if(sujeito == atacante){
            bt53.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt53.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt53.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[26] = true;
        }
    } //ok
    public void button55(int sujeito){
        if(sujeito == atacante){
            bt55.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt55.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt55.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[27] = true;
        }
    } //ok

    //8 - oitava fila de botoes ok

    public void button58(int sujeito){
        if(sujeito == atacante){
            bt58.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt58.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt58.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[28] = true;
        }
    } //ok
    public void button60(int sujeito){
        if(sujeito == atacante){
            bt60.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt60.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt60.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[29] = true;
        }
    } //ok

    public void button62(int sujeito){
        if(sujeito == atacante){
            bt62.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt62.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt62.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[30] = true;
        }
    } //ok
    public void button64(int sujeito){
        if(sujeito == atacante){
            bt64.setBackground(new Color(a1,a2,a3));
        }
        if(sujeito == vitima){
            bt64.setBackground(new Color(v1,v2,v3));
        }
        if(sujeito == casaFinal){
            bt64.setBackground(new Color(cf1,cf2,cf3));
            vetorcf[31] = true;
        }
    } //ok


    public void tingirAtaque(int cordenada, int  sujeito){
        //tinfir a casa atacante
        //tingit a casa atacada
        //tingir a casa final do atacante
        switch (cordenada) {
            case 1:
                if(sujeito == atacante){button1(atacante);}
                if(sujeito == vitima){button1(vitima);}
                if(sujeito == casaFinal){button1(casaFinal);}
                break;
            case 3:
                if(sujeito == atacante){button3(atacante);}
                if(sujeito == vitima){button3(vitima);}
                if(sujeito == casaFinal){button3(casaFinal);}
                break;
            case 5:
                if(sujeito == atacante){button5(atacante);}
                if(sujeito == vitima){button5(vitima);}
                if(sujeito == casaFinal){button5(casaFinal);}
                break;
            case 7:
                if(sujeito == atacante){button7(atacante);}
                if(sujeito == vitima){button7(vitima);}
                if(sujeito == casaFinal){button7(casaFinal);}
                break;

            //linha 1
            case 10:
                if(sujeito == atacante){button10(atacante);}
                if(sujeito == vitima){button10(vitima);}
                if(sujeito == casaFinal){button10(casaFinal);}
                break;
            case 12:
                if(sujeito == atacante){button12(atacante);}
                if(sujeito == vitima){button12(vitima);}
                if(sujeito == casaFinal){button12(casaFinal);}
                break;
            case 14:
                if(sujeito == atacante){button14(atacante);}
                if(sujeito == vitima){button14(vitima);}
                if(sujeito == casaFinal){button14(casaFinal);}
                break;
            case 16:
                if(sujeito == atacante){button16(atacante);}
                if(sujeito == vitima){button16(vitima);}
                if(sujeito == casaFinal){button16(casaFinal);}
                break;

            //linha 2
            case 17:
                if(sujeito == atacante){button17(atacante);}
                if(sujeito == vitima){button17(vitima);}
                if(sujeito == casaFinal){button17(casaFinal);}
                break;
            case 19:
                if(sujeito == atacante){button19(atacante);}
                if(sujeito == vitima){button19(vitima);}
                if(sujeito == casaFinal){button19(casaFinal);}
                break;
            case 21:
                if(sujeito == atacante){button21(atacante);}
                if(sujeito == vitima){button21(vitima);}
                if(sujeito == casaFinal){button21(casaFinal);}
                break;
            case 23:
                if(sujeito == atacante){button23(atacante);}
                if(sujeito == vitima){button23(vitima);}
                if(sujeito == casaFinal){button23(casaFinal);}
                break;

            //linha 3
            case 26:
                if(sujeito == atacante){button26(atacante);}
                if(sujeito == vitima){button26(vitima);}
                if(sujeito == casaFinal){button26(casaFinal);}
                break;
            case 28:
                if(sujeito == atacante){button28(atacante);}
                if(sujeito == vitima){button28(vitima);}
                if(sujeito == casaFinal){button28(casaFinal);}
                break;
            case 30:
                if(sujeito == atacante){button30(atacante);}
                if(sujeito == vitima){button30(vitima);}
                if(sujeito == casaFinal){button30(casaFinal);}
                break;
            case 32:
                if(sujeito == atacante){button32(atacante);}
                if(sujeito == vitima){button32(vitima);}
                if(sujeito == casaFinal){button32(casaFinal);}
                break;

            //linha 4
            case 33:
                if(sujeito == atacante){button33(atacante);}
                if(sujeito == vitima){button33(vitima);}
                if(sujeito == casaFinal){button33(casaFinal);}
                break;
            case 35:
                if(sujeito == atacante){button35(atacante);}
                if(sujeito == vitima){button35(vitima);}
                if(sujeito == casaFinal){button35(casaFinal);}
                break;
            case 37:
                if(sujeito == atacante){button37(atacante);}
                if(sujeito == vitima){button37(vitima);}
                if(sujeito == casaFinal){button37(casaFinal);}
                break;
            case 39:
                if(sujeito == atacante){button39(atacante);}
                if(sujeito == vitima){button39(vitima);}
                if(sujeito == casaFinal){button39(casaFinal);}
                break;

            //linha 5
            case 42:
                if(sujeito == atacante){button42(atacante);}
                if(sujeito == vitima){button42(vitima);}
                if(sujeito == casaFinal){button42(casaFinal);}
                break;
            case 44:
                if(sujeito == atacante){button44(atacante);}
                if(sujeito == vitima){button44(vitima);}
                if(sujeito == casaFinal){button44(casaFinal);}
                break;
            case 46:
                if(sujeito == atacante){button46(atacante);}
                if(sujeito == vitima){button46(vitima);}
                if(sujeito == casaFinal){button46(casaFinal);}
                break;
            case 48:
                if(sujeito == atacante){button48(atacante);}
                if(sujeito == vitima){button48(vitima);}
                if(sujeito == casaFinal){button48(casaFinal);}
                break;

            //linha 6
            case 49:
                if(sujeito == atacante){button49(atacante);}
                if(sujeito == vitima){button49(vitima);}
                if(sujeito == casaFinal){button49(casaFinal);}
                break;
            case 51:
                if(sujeito == atacante){button51(atacante);}
                if(sujeito == vitima){button51(vitima);}
                if(sujeito == casaFinal){button51(casaFinal);}
                break;
            case 53:
                if(sujeito == atacante){button53(atacante);}
                if(sujeito == vitima){button53(vitima);}
                if(sujeito == casaFinal){button53(casaFinal);}
                break;
            case 55:
                if(sujeito == atacante){button55(atacante);}
                if(sujeito == vitima){button55(vitima);}
                if(sujeito == casaFinal){button55(casaFinal);}
                break;

            //linha 7
            case 58:
                if(sujeito == atacante){button58(atacante);}
                if(sujeito == vitima){button58(vitima);}
                if(sujeito == casaFinal){button58(casaFinal);}
                break;
            case 60:
                if(sujeito == atacante){button60(atacante);}
                if(sujeito == vitima){button60(vitima);}
                if(sujeito == casaFinal){button60(casaFinal);}
                break;
            case 62:
                if(sujeito == atacante){button62(atacante);}
                if(sujeito == vitima){button62(vitima);}
                if(sujeito == casaFinal){button62(casaFinal);}
                break;
            case 64:
                if(sujeito == atacante){button64(atacante);}
                if(sujeito == vitima){button64(vitima);}
                if(sujeito == casaFinal){button64(casaFinal);}
                break;

        }


    }

}

