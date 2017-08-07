package notificaca;


import MoverJanela.MoveWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by marcos on 01/07/16.
 */
public class aviso extends JFrame {

    private static final int Altura = 10;
    private static final int largura = 20;

    JPanel info;
    MoveWindow mvjanela;
    JButton bt_mensagem;


    public aviso(String mensagem){


        bt_mensagem = new JButton(mensagem);

        setUndecorated(true);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        System.out.println("Valor do botao : "+bt_mensagem.getHeight() +" : "+bt_mensagem.getWidth());
        setSize(300,200);

        info = new JPanel();
        info.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(info);
        info.add(bt_mensagem);

        //info.setLayout(null);


        mvjanela = new MoveWindow(this); //instancia para retirar as botoes do sistemas na janela
        addMouseMotionListener(mvjanela);

    }


}
