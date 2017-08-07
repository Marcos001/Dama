package vsAmiguinhoRede;

import vsAmiguinhoRede.com.auxiliar.pingLocal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by marcos on 01/07/16.
 */

public class Escolha extends JFrame implements ActionListener{

    ImageIcon cb_on = new ImageIcon(getClass().getResource("../imagens/check_box/check_box_on.png"));
    ImageIcon cb_off = new ImageIcon(getClass().getResource("../imagens/check_box/check_box_off.png"));
    ImageIcon cb_off_des = new ImageIcon(getClass().getResource("../imagens/check_box/check_box_off_des.png"));

    private JPanel painel_top;
    private JPanel painel_left;
    private JPanel painel_right;

    private JLabel lb_servidor;
    private JLabel lb_cliente;
    private JLabel cb_servidor;
    private JLabel cb_cliente;
    private JLabel lb_info;
    private JLabel lb_porta;
    private JLabel lb_ip;
    private JLabel lb_user;
    private JLabel lb_info_ip = new JLabel();
    private JLabel lb_status_conexao;

    private JButton bt_start;
    private JButton bt_mudar_porta;
    private JButton bt_verificar_ip;

    private JTextField ct_porta;
    private JTextField ct_ip_edit;
    private JFormattedTextField ct_porta_edit;

    private boolean bl_servidor = true;
    private boolean bl_cliente = false;
    private boolean bl_valida_ip_servidor = true;

    private int porta = 12345;
    private String ip;
    private String user;

    private pingLocal ping;


    private void atribuir() throws SocketException, UnknownHostException {
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        while (e.hasMoreElements()) {
            NetworkInterface i = (NetworkInterface) e.nextElement();
            Enumeration ds = i.getInetAddresses();
            InetAddress ttt = InetAddress.getLocalHost();
            user = ttt.getHostName();
            while (ds.hasMoreElements()) {
                InetAddress myself = (InetAddress) ds.nextElement();
                System.out.println("HostName: " + myself.getHostName() + " IP: " + myself.getHostAddress());
                if (!myself.isLoopbackAddress() && myself.isSiteLocalAddress()) {
                    ip = myself.getHostAddress();
                }
            }
        }
    }

    private void fun_set_componentes_for_servidor(){
        lb_info_ip.setText("Digite o Ip : ");
        lb_info_ip.setBounds(10,110,120,25);
        ct_ip_edit.setBounds(110,110,140,25);
    }

    private void fun_set_componentes_for_cliente(){
        lb_info_ip.setText("Digite o Ip do Servidor : ");
        lb_info_ip.setBounds(10,110,180,25);
        ct_ip_edit.setBounds(200,110,140,25);
    }

    private void fun_valida_bt_start(){
        if(bl_valida_ip_servidor){
            bt_start.setEnabled(true);
        }
        else{
            bt_start.setEnabled(false);
        }
    }

    private void set_posicoes_painel_right(){
        painel_right = new JPanel();
        painel_right.setLayout(null);
        painel_right.setBounds(245,80,480,350);
       // painel_right.setBackground(new Color(180,180,180));


        JLabel info_porta = new JLabel("Mudar a porta >"); //label de info porta
        info_porta.setBounds(10,10,200,25);
        info_porta.setForeground(new Color(100,129,255));
        painel_right.add(info_porta);


        ct_porta_edit = new JFormattedTextField(""+porta);
        ct_porta_edit.setColumns(5);
        ct_porta_edit.setBounds(20,45,75,25);
        ct_porta_edit.setForeground(new Color(57,217,25));
        painel_right.add(ct_porta_edit);

        bt_mudar_porta = new JButton("Alterar"); //botao de mudar porta
        bt_mudar_porta.setBounds(100,45,100,25);
        bt_mudar_porta.setBackground(new Color(100,129,255));
        bt_mudar_porta.setForeground(new Color(255,255,233));
        painel_right.add(bt_mudar_porta);

        JLabel info_text_conect = new JLabel("Verificar Disponibilidade de outro Host >");
        info_text_conect.setBounds(10,80,300,25);
        info_text_conect.setForeground(new Color(100,129,255));
        painel_right.add(info_text_conect);

        lb_info_ip.setForeground(new Color(100,129,255));
        painel_right.add(lb_info_ip);

        ct_ip_edit = new JTextField();
        ct_ip_edit.setForeground(new Color(57,217,25));
        painel_right.add(ct_ip_edit);

        fun_set_componentes_for_servidor();

        bt_verificar_ip = new JButton("Verificar"); //botao de mudar porta
        bt_verificar_ip.setBounds(50,150,100,25);
        bt_verificar_ip.setBackground(new Color(100,129,255));
        bt_verificar_ip.setForeground(new Color(255,255,233));
        painel_right.add(bt_verificar_ip);

        lb_status_conexao = new JLabel("");
        lb_status_conexao.setBounds(170,150,300,25);
        painel_right.add(lb_status_conexao);
    }

    private void set_Posicoes(){

          lb_info = new JLabel("Escolha o Tipo de Conexão!");
          painel_top = new JPanel(); //*********painel top
          painel_top.setBackground(new Color(100,100,100));
          painel_top.add(lb_info);
          painel_top.setBounds(0,0,750,30);

          JLabel lb_info_esq = new JLabel("Tipo de conexão >");
          lb_info_esq.setBounds(10,15,150,25);

          cb_servidor = new JLabel(cb_on); //componetes do servidor
          cb_servidor.setBounds(10,50,25,25);
          lb_servidor = new JLabel(" SERVIDOR ");
          lb_servidor.setForeground(new Color(57,217,25));
          lb_servidor.setBounds(40,50,150,25);

          cb_cliente = new JLabel(cb_off);
          cb_cliente.setBounds(10,100,25,25);//componentes do cliente
          lb_cliente = new JLabel(" CLIENTE ");
          lb_cliente.setForeground(new Color(10,10,10));
          lb_cliente.setBounds(40,100,150,25);

          lb_porta = new JLabel("Porta  : ");
          lb_porta.setBounds(20,160,75,20);
          ct_porta = new JTextField(" "+porta);//componentes do servidor
          ct_porta.setBounds(80,160,80,20);
          ct_porta.setEditable(false);

          //part para pegar informações de rede da maquina

          try {
            atribuir();
            if(ip == null){
                lb_ip = new JLabel("IP : Sem Conexão");
            }
            else{
                lb_ip = new JLabel("IP : "+ip);
            }
            lb_user = new JLabel("User : "+user);
          }catch(IOException erro){
            lb_ip = new JLabel("IP : Sem Conexão");
            lb_user = new JLabel("User : Sem Conexão");
          }

           lb_user.setBounds(20,190,150,25);
           lb_ip.setBounds(20,220,150,25);

        //------------------------------------

          painel_left = new JPanel(); //painel de rede
          painel_left.setLayout(null);
          painel_left.setBackground(new Color(100,100,100));
          painel_left.setBounds(10,50,200,400);
          painel_left.add(cb_servidor);
          painel_left.add(lb_servidor);

          painel_left.add(cb_cliente);
          painel_left.add(lb_cliente);
          painel_left.add(lb_info_esq);

          painel_left.add(lb_porta);
          painel_left.add(ct_porta);

          painel_left.add(lb_user);
          painel_left.add(lb_ip);

        cb_cliente.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fun_marcar_selecionado(false,true);
                fun_set_componentes_for_cliente();
                bl_valida_ip_servidor = false;
               fun_valida_bt_start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
              if(!bl_cliente){
                  cb_cliente.setIcon(cb_off_des);
              }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(!bl_cliente){
                    cb_cliente.setIcon(cb_off);
                }
            }
        });

        //servidor

        cb_servidor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fun_marcar_selecionado(true,false);
                fun_set_componentes_for_servidor();
                bl_valida_ip_servidor = true;
                fun_valida_bt_start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(!bl_servidor){
                    cb_servidor.setIcon(cb_off_des);

                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(!bl_servidor){
                    cb_servidor.setIcon(cb_off);
                }
            }
        });
    }//fim do construtor

    private void fun_marcar_selecionado(boolean s,boolean c){
        if(s){
            cb_servidor.setIcon(cb_on);
            lb_servidor.setForeground(new Color(57,217,25));
            cb_cliente.setIcon(cb_off);
            lb_cliente.setForeground(new Color(10,10,10));
            bl_servidor = true;
            bl_cliente = false;
        }
        if(c){
            cb_servidor.setIcon(cb_off);
            lb_servidor.setForeground(new Color(10,10,10));
            cb_cliente.setIcon(cb_on);
            lb_cliente.setForeground(new Color(57,217,25));
            bl_servidor = false;
            bl_cliente = true;
        }
    }

    public Escolha(){

         ping = new pingLocal();
        set_Posicoes();
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(350, 100, 750, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(painel_top);
        this.add(painel_left);
        set_posicoes_painel_right();
        this.add(painel_right);

        bt_start = new JButton("START");
        bt_start.setBounds(450,450,100,25);
        bt_start.setBackground(new Color(100,129,255));
        bt_start.setForeground(new Color(255,255,233));
        fun_valida_bt_start();
        this.add(bt_start);


        bt_mudar_porta.addActionListener(this);
        bt_verificar_ip.addActionListener(this);
        bt_start.addActionListener(this);


        this.setVisible(true);
    } //construtor

    private void fun_mudar_porta(String st_porta){
        //so numeros
        //porta nao tem mais q 5 numeros
        int num_porta = Integer.parseInt(st_porta);
        print("Numero convertido",""+num_porta);
        porta = num_porta;
        ct_porta.setText(""+porta);

    }

    private void fun_confere_letras(String n){
        int quant = 0;
        for (int i =0;i<n.length();i++){
            char l = n.charAt(i);

            if(l == '0' || l == '1' ||  l == '2' || l =='3' || l == '4' ||
                    l == '5' || l == '6' || l == '7' || l == '8' || l == '9'){
                print("Numero : ",""+l);
                quant++;
            }
        }
        if(quant == n.length()){
            print("Numero Valiado","");
            fun_mudar_porta(n);
        }else{
            print("Numero invalido","");
        }
    }

    private void fun_validar_campo(){
        print("Valor do Campo da porta : ",ct_porta_edit.getText());
        if(ct_porta_edit.getText().length() <= 5){
            fun_confere_letras(ct_porta_edit.getText());
        }
        else{
            JOptionPane.showMessageDialog(null,"Informe um numero de 0 a 65535");
        }
    }

    private boolean fun_teste_coneccao(){
      if(ping.ping(ct_ip_edit.getText())){
          lb_status_conexao.setText("O host "+ct_ip_edit.getText()+" está disponével!");
          lb_status_conexao.setForeground(new Color(1,187,40));
          bl_valida_ip_servidor = true;
         fun_valida_bt_start();
          return true;
      }
        else{
          lb_status_conexao.setText("O host "+ct_ip_edit.getText()+" não está disponével!");
          lb_status_conexao.setForeground(new Color(230,38,38));
          bl_valida_ip_servidor = false;
          fun_valida_bt_start();
          return false;
      }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == bt_mudar_porta){
            fun_validar_campo();
        }


        if(e.getSource() == bt_verificar_ip){
            fun_teste_coneccao();
        }


        if (e.getSource() == bt_start){
            if(bl_servidor){
                print("Chama a nova Janela","");
                new game_main_humano("esqq","dirr",10);
                fun_close_windows();
            }
            else
            if( fun_teste_coneccao()){
                print("Chama a nova Janela","");
                new game_main_humano("esq","dir",20);
                fun_close_windows();
            }
            else{
                print("Parametros incorretos","");
            }

        }

    }

    private void fun_close_windows(){
        this.dispose();
    }

    public void print(String coment,String nome){
        System.out.println("::"+coment +" "+nome);
    }
}
