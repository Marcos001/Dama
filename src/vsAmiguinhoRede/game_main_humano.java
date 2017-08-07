package vsAmiguinhoRede;

import Indice.indice;
import Painel.painel;
import save.GerenciadorDados;
import sun.awt.windows.ThemeReader;
import vsHumano.Painel_tabuleiro;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ServiceConfigurationError;

/**
 * Created by marcos on 02/06/16.
 * http://www.tecmundo.com.br/video-game-e-jogos/106138-reboot-continuacao-entenda-melhor-kratos-novo-god-of-war.htm?utm_source=facebook.com&utm_medium=referral&utm_campaign=thumb
 */

/*Classe que eh a tela do jogabilidade,
* */

public class game_main_humano extends JFrame implements ActionListener {


    //novas declaracoes
    public ObjectOutputStream output; //gera o fluxo de saida para o cliente
    public ObjectInputStream input; // gera o fluxo de entrada a apartir do cliente

    public ServerSocket server; //socket de servidor
    public Socket connection; //conexao com o cliente

    public int counter = 1;

    //DECLARAÇOES

    RodarTempo r = new RodarTempo();
    Conexao c = new Conexao();
    GerenciadorDados save = new GerenciadorDados();
    indice l_cord = new indice(1);
    indice c_cord = new indice(0);
    painel p1;
    painel p2;

    JTextField ct_enterField; //insere a mensagem do usuário
    JTextArea cta_displayArea; //exibe as informações para o usuário


    JPanel painelGeral = new JPanel();
    private JPanel painel_chat;
    JPanel painel_info_player; //painel para a exibir informações sobre os jogadores
    private JPanel contentPane;
    painel_tabuleiro_rede p = new painel_tabuleiro_rede();

    //imagens para representar o jogador

    ImageIcon fundo = new ImageIcon(getClass().getResource("../imagens/fundo_jogo.jpeg"));
    ImageIcon j1 = new ImageIcon(getClass().getResource("../imagens/mdi/icon_player_hum_azul_mdi.png"));
    ImageIcon j2 = new ImageIcon(getClass().getResource("../imagens/mdi/icon_player_hum_red_mdi.png"));

    JLabel lb_total_pecas;
    JLabel lb_pecas_normais;
    JLabel lb_pecas_rainha;
    JLabel lb_background = new JLabel(fundo);
    JLabel lb_icone_jogador1_esq = new JLabel(j1);
    JLabel lb_icone_jogador2_dir = new JLabel(j2);


    JButton bt_home = new JButton();
    JButton bt_ranking = new JButton();
    JButton bt_reiniciar = new JButton();
    JButton bt_sair = new JButton();
    JButton bt_tempo = new JButton();


    private int c1 = 60, c2 = 179, c3 = 130;
    private int segundos;
    private int minutos;
    private static final int servidor = 10;
    private static final int cliente = 20;
    private int conexao = 0;

    //configuracao do painel do tabuleiro

    public void addPainelGeral() {

        c_cord.setBounds(60, 10, 500, 30);
        c_cord.setBackground(new Color(179, 179, 179));
        p.setBounds(50, 50, 500, 500);
        l_cord.setBounds(20, 50, 30, 500);
        l_cord.setBackground(new Color(179, 179, 179));

        painelGeral.add(l_cord);
        painelGeral.add(c_cord);
        painelGeral.add(p);
        painelGeral.setBounds(10, 10, 600, 600);
        painelGeral.setBackground(new Color(179, 179, 179));
        painelGeral.setVisible(true);
        painelGeral.setLayout(null);
    }

    private void fun_add_chat() {

        painel_chat = new JPanel();
        painel_chat.setLayout(new BorderLayout());
        painel_chat.setBounds(25, 230, 200, 200);

        ct_enterField = new JTextField();
        ct_enterField.setEditable(false);
        ct_enterField.addActionListener(
                new ActionListener() {  //cria uma acao
                    //envia a mensagem ao cliente
                    public void actionPerformed(ActionEvent event) {
                        c.sendData(event.getActionCommand());
                        ct_enterField.setText("");
                    }//fim do metodo actionPerformed
                }//fim da classe interna anonima
        );//fim da chamada para addActionListener

        painel_chat.add(ct_enterField, BorderLayout.NORTH);
        cta_displayArea = new JTextArea("");//cria displayArea

        painel_chat.add(new JScrollPane(cta_displayArea), BorderLayout.CENTER);
        p1.add(painel_chat);

    }

    //contrututor da classe

    public game_main_humano(String nome1, String nome2, int tipo_conexao) {
        //propriedades das janelas

        this.conexao = tipo_conexao;


        setResizable(false);
        setBounds(100, 0, 1200, 650);
        setVisible(true);
        addPainelGeral();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(c1, c2, c3));
        painelGeral.setBounds(300, 80, 600, 550);
        //getContentPane().add(painelGeral);
        lb_background.setBounds(0, 0, 1200, 650);
        add(painelGeral);


        //menu info dos jogadores da esquerda
        // painel_info_player = new painel();

        config_elementos_menu_info(2, 20);


        if (conexao == servidor) {
            //M("Servidor");

            //painel dos jogadores esquerda
            p1 = new painel();
            p1.setBounds(20, 80, 250, 550);
            p1.setLayout(null);
            add(p1);


            p.lb_player1.setBounds(15, 10, 230, 50);
            lb_icone_jogador1_esq.setBounds(25, 70, 100, 100); //***************************************
            p.jogador1_vez.setBounds(130, 70, 100, 100);

            //painel do chat

            fun_add_chat();


            p.lb_player1_quant_pc.setBounds(30, 450, 200, 30);
            p.lb_player1_quant_pontos.setBounds(60, 470, 200, 30);


            p.lb_player1.setText(nome1);
            p.lb_player1.setFont(new Font("Sans Serif", Font.PLAIN, 20));
            p.lb_player1.setBackground(new Color(70, 216, 80));
            p1.add(lb_icone_jogador1_esq);
            p1.add(p.lb_player1);
            p1.add(p.jogador1_vez);
            p1.add(p.lb_player1_quant_pc);
            p1.add(p.lb_player1_quant_pontos);


        } else {
            // M("Cliente");

            //painel dos jogadores  direita
            p2 = new painel();
            p2.setLayout(null);
            p2.setBounds(930, 80, 250, 550);
            add(p2);
            p.lb_player2.setBounds(15, 10, 230, 50);
            lb_icone_jogador2_dir.setBounds(25, 60, 100, 100);
            p.jogador2_vez.setBounds(130, 70, 100, 100);
            p.lb_player2_quant_pc.setBounds(30, 450, 200, 30);
            p.lb_player2_quant_pontos.setBounds(60, 470, 200, 30);


            p.lb_player2.setText(nome2);
            p.lb_player2.setFont(new Font("Sans Serif", Font.PLAIN, 20));

            p2.add(lb_icone_jogador2_dir);
            p2.add(p.lb_player2);
            p2.add(p.jogador2_vez);
            p2.add(p.lb_player2_quant_pc);
            p2.add(p.lb_player2_quant_pontos);

        }

        //painel onde contem o titulo da aplicação
        painel menu_titulo = new painel();
        menu_titulo.setBounds(200, 0, 800, 30);
        JLabel titulo = new JLabel("DAMAS");
        menu_titulo.add(titulo);

        //painel no menu que contem os botoes
        painel menu_botoes = new painel();
        menu_botoes.setLayout(new GridLayout());
        menu_botoes.setBounds(200, 30, 800, 40);
        config_elementos_menu();
        menu_botoes.add(bt_home);
        menu_botoes.add(bt_ranking);
        menu_botoes.add(bt_tempo);
        menu_botoes.add(bt_reiniciar);
        menu_botoes.add(bt_sair);

        //painel onde mostrara o titulo do jogo e os botoes
        painel menu = new painel();
        menu.setBounds(200, 0, 800, 70);
        add(menu_titulo);
        add(menu_botoes);
        menu.setLayout(new GridLayout(2, 5));
        add(lb_background);

        addAcaoButton();
        r.start();
        c.start();
    }




    private void config_elementos_menu_info(int comun, int rainha) {
        lb_total_pecas = new JLabel();
        lb_pecas_normais = new JLabel();
        lb_pecas_rainha = new JLabel();

        lb_total_pecas.setText("Total peças : " + p.quant_pecas(comun) + p.quant_pecas(rainha));
        lb_pecas_normais.setText("Peças Comuns : " + p.quant_pecas(comun));
        lb_pecas_rainha.setText("Peças Rainhas : " + p.quant_pecas(rainha));
    }



    private void config_elementos_menu() {
        bt_home.setText("HOME");
        bt_home.setForeground(new Color(c1, c2, c3));
        bt_ranking.setText("RANKING");
        bt_ranking.setForeground(new Color(c1, c2, c3));
        bt_tempo.setText(" TIME  00:00 ");
        bt_tempo.setForeground(new Color(c1, c2, c3));
        bt_reiniciar.setText("REINICIAR");
        bt_reiniciar.setForeground(new Color(c1, c2, c3));
        bt_sair.setText("SAIR");
        bt_sair.setForeground(new Color(c1, c2, c3));
    }

    private void addAcaoButton() {
        bt_home.addActionListener(this);
        bt_reiniciar.addActionListener(this);
        bt_ranking.addActionListener(this);
        bt_sair.addActionListener(this);
    }


    //acao para os botoes
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bt_home) {
            //chamar a tela inicial
            //Launcher l = new Launcher();
            //l.main(null);
            super.dispose();
        }

        if (e.getSource() == bt_ranking) {
            //chamar a tela de ranking
        }

        if (e.getSource() == bt_reiniciar) {
            //reiniciar a matriz
            p.reiniciar_tabuleiro();
            minutos = 0;
            segundos = 0;

        }

        if (e.getSource() == bt_sair) {
            //sair da aplicação
            System.exit(0);
        }
    }


    public class RodarTempo extends Thread {
        public void run() {

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception erro) {
                }

                segundos++;

                if (segundos < 10) {
                    bt_tempo.setText("Tempo  0" + minutos + ":0" + segundos + " ");
                } else if (segundos > 9 && segundos < 60) {
                    bt_tempo.setText("Tempo  0" + minutos + ":" + segundos + " ");
                } else if (segundos == 60) {
                    minutos++;
                    segundos = 0;
                    bt_tempo.setText("Tempo  0" + minutos + ":0" + segundos + " ");

                }
            }
        }

    }


    public class Conexao extends Thread{

        private void M(String m) {
            System.out.println(m);
        }

        public void runServer() {

            M("Entrou em Server");
            try {//config o servidor para receber conexões; processa as conexoes
                server = new ServerSocket(12345, 100); //cria ServerSpcket
                M("instacioou 'server'");

                try {
                    M("aguardando");
                    waitForConnection();
                    M("termindo");
                    getStreams();
                    ProcessConection();
                } catch (EOFException e) {
                    M("Servidor terminadoa conexao");
                    displayMessage("\nServer Termined connection");
                } finally {
                    M("Conexao fechada");
                    closeConection(); //fecha a conexao
                    ++counter;
                }

            } catch (IOException io) {
                M("Porta nao aceita");
                io.printStackTrace();
            }
        }

        //espera que a conexao chegue e então exibe informações sobre a conexão
        public void waitForConnection() throws IOException {
            displayMessage("Aguardando Conexão...");
            connection = server.accept(); //permite que o servidor aceite a conexão

            displayMessage("Connection " + counter + " received from: " + connection.getInetAddress().getHostName());
        }

        //ontém fluxos para enviar e receber dados
        public void getStreams() throws IOException {
            //configura o fluxo de saida de dados
            output = new ObjectOutputStream(connection.getOutputStream());
            //configura o fluxo de entrada de dados
            input = new ObjectInputStream(connection.getInputStream());

            displayMessage("\n I/O streams\n");
        }

        //processa a conexão com o cliente
        public void ProcessConection() throws IOException {
            String message = "Connection sucessful!";
            sendData(message);//envia uma menssagem de conexão bem sucedida

            //ativa a enterField de modo que o usuário do servidor possa enviar menssagens
            setTextFieldEditable(true);

            //processa as menssagens enviadas pelo cliente
            do {

                try {//lê e exibe a menssagem
                    message = (String) input.readObject();//lê uma nova menssagem
                    displayMessage("\n" + message);
                } catch (ClassNotFoundException c) {
                    displayMessage("\nUnknowm object type received");
                }

            } while (!message.equals("CLIENT>>> TERMINATE"));
        }

        //fecha os fluxos e os sockets
        public void closeConection() {

            displayMessage("\nTerminating connection\n");
            setTextFieldEditable(false);//desativa a enterField

            try {
                output.close();
                input.close();
                connection.close();
            } catch (IOException io) {
            }

        }

        //envia menssagem ao cliente
        public void sendData(String message) {

            try {
                output.writeObject("SERVER>> " + message);
                output.flush();//esvazia a saida para o cliente
                displayMessage("\nSERVER>> " + message);
            } catch (IOException io) {
                //cta_displayArea.append("\nError writing objetc");
            }

        }


        //manipula a displayArea na  thread de despacho de eventos
        public void displayMessage(final String messageToDisplay) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    cta_displayArea.append(messageToDisplay);

                }

            });
        }


        //manipula a displayArea na Thread de despacho de eventos
        public void setTextFieldEditable(boolean b) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ct_enterField.setEditable(b);
                }
            });
        }

        @Override
        public void run() {

            runServer();
        }
    }
}

