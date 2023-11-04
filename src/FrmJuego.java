

import Vista.*;
import Controlador.Juego;
import Modelo.TableroBuscaminas;
import Modelo.CasillaAbiertaListener;
import Modelo.PartidaGanadaListener;
import Modelo.Casilla;
import Modelo.PartidaPerdidaListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ´Felipe Chacón
 */
public class FrmJuego extends javax.swing.JFrame {

    private javax.swing.Timer temporizador;
    private boolean juegoIniciado = false;
    private int tiempoTranscurrido = 0;
    private Juego juego;

    int numFilas = 12;
    int numColumnas = 12;
    int numMinas = 30;

    JButton[][] matrizBtn;
    TableroBuscaminas tableroBuscaminas;

    /**
     * Creates new form FrmJuego
     */
    public FrmJuego() {
        initComponents();
        juegoNuevo();
        tiem.setText("0");
    }

    void descargarControles() {
        if (matrizBtn != null) {
            for (int i = 0; i < matrizBtn.length; i++) {
                for (int j = 0; j < matrizBtn[i].length; j++) {
                    if (matrizBtn[i][j] != null) {
                        getContentPane().remove(matrizBtn[i][j]);
                    }
                }
            }
        }
    }

    private void juegoNuevo() {
        descargarControles();
        inicializarMatrizBtn();
        asignarBotones();
        configurarEventos();

        juego = new Juego(numFilas, numColumnas, numMinas);

        juego.setPartidaPerdidaListener(new PartidaPerdidaListener() {
            @Override
            public void partidaPerdida(List<Casilla> t) {
                for (Casilla casillaConMina : t) {
                    matrizBtn[casillaConMina.getPosFila()][casillaConMina.getPosColumna()].setText("*");
                }
            }
        });

        juego.setPartidaGanadaListener(new PartidaGanadaListener() {
            @Override
            public void partidaGanada(List<Casilla> t) {
                for (Casilla casillaConMina : t) {
                    matrizBtn[casillaConMina.getPosFila()][casillaConMina.getPosColumna()].setText(":)");
                }
            }
        });

        juego.setCasillaAbiertaListener(new CasillaAbiertaListener() {
            @Override
            public void casillaAbierta(Casilla t) {
                matrizBtn[t.getPosFila()][t.getPosColumna()].setEnabled(false);
                matrizBtn[t.getPosFila()][t.getPosColumna()]
                        .setText(t.getNumMinasAlrededor() == 0 ? "" : t.getNumMinasAlrededor() + "");
            }
        });
    }

    private void inicializarMatrizBtn() {
        matrizBtn = new JButton[numFilas][numColumnas];
        // Asigna los botones de la matriz a matrizBtn
        matrizBtn[0][0] = btn00;
        matrizBtn[0][1] = btn02;
        matrizBtn[0][2] = btn03;
        matrizBtn[0][3] = btn04;
        matrizBtn[0][4] = btn05;
        matrizBtn[0][5] = btn06;
        matrizBtn[0][6] = btn07;
        matrizBtn[0][7] = btn08;
        matrizBtn[0][8] = btn09;
        matrizBtn[0][9] = btn10;
        matrizBtn[0][10] = btn11;
        matrizBtn[0][11] = btn12;
        matrizBtn[1][0] = btn13;
        matrizBtn[1][1] = btn14;
        matrizBtn[1][2] = btn15;
        matrizBtn[1][3] = btn16;
        matrizBtn[1][4] = btn17;
        matrizBtn[1][5] = btn18;
        matrizBtn[1][6] = btn19;
        matrizBtn[1][7] = btn20;
        matrizBtn[1][8] = btn21;
        matrizBtn[1][9] = btn22;
        matrizBtn[1][10] = btn23;
        matrizBtn[1][11] = btn24;
        matrizBtn[2][0] = btn25;
        matrizBtn[2][1] = btn26;
        matrizBtn[2][2] = btn27;
        matrizBtn[2][3] = btn28;
        matrizBtn[2][4] = btn29;
        matrizBtn[2][5] = btn30;
        matrizBtn[2][6] = btn31;
        matrizBtn[2][7] = btn32;
        matrizBtn[2][8] = btn33;
        matrizBtn[2][9] = btn34;
        matrizBtn[2][10] = btn35;
        matrizBtn[2][11] = btn36;
        matrizBtn[3][0] = btn37;
        matrizBtn[3][1] = btn38;
        matrizBtn[3][2] = btn39;
        matrizBtn[3][3] = btn40;
        matrizBtn[3][4] = btn41;
        matrizBtn[3][5] = btn42;
        matrizBtn[3][6] = btn43;
        matrizBtn[3][7] = btn44;
        matrizBtn[3][8] = btn45;
        matrizBtn[3][9] = btn46;
        matrizBtn[3][10] = btn47;
        matrizBtn[3][11] = btn48;
        matrizBtn[4][0] = btn49;
        matrizBtn[4][1] = btn50;
        matrizBtn[4][2] = btn51;
        matrizBtn[4][3] = btn52;
        matrizBtn[4][4] = btn53;
        matrizBtn[4][5] = btn54;
        matrizBtn[4][6] = btn55;
        matrizBtn[4][7] = btn56;
        matrizBtn[4][8] = btn57;
        matrizBtn[4][9] = btn58;
        matrizBtn[4][10] = btn59;
        matrizBtn[4][11] = btn60;
        matrizBtn[5][0] = btn61;
        matrizBtn[5][1] = btn62;
        matrizBtn[5][2] = btn63;
        matrizBtn[5][3] = btn64;
        matrizBtn[5][4] = btn65;
        matrizBtn[5][5] = btn66;
        matrizBtn[5][6] = btn67;
        matrizBtn[5][7] = btn68;
        matrizBtn[5][8] = btn69;
        matrizBtn[5][9] = btn70;
        matrizBtn[5][10] = btn71;
        matrizBtn[5][11] = btn72;
        matrizBtn[6][0] = btn73;
        matrizBtn[6][1] = btn74;
        matrizBtn[6][2] = btn75;
        matrizBtn[6][3] = btn76;
        matrizBtn[6][4] = btn77;
        matrizBtn[6][5] = btn78;
        matrizBtn[6][6] = btn79;
        matrizBtn[6][7] = btn80;
        matrizBtn[6][8] = btn81;
        matrizBtn[6][9] = btn82;
        matrizBtn[6][10] = btn83;
        matrizBtn[6][11] = btn84;
        matrizBtn[7][0] = btn85;
        matrizBtn[7][1] = btn86;
        matrizBtn[7][2] = btn87;
        matrizBtn[7][3] = btn88;
        matrizBtn[7][4] = btn89;
        matrizBtn[7][5] = btn90;
        matrizBtn[7][6] = btn91;
        matrizBtn[7][7] = btn92;
        matrizBtn[7][8] = btn93;
        matrizBtn[7][9] = btn94;
        matrizBtn[7][10] = btn95;
        matrizBtn[7][11] = btn96;
        matrizBtn[8][0] = btn97;
        matrizBtn[8][1] = btn98;
        matrizBtn[8][2] = btn99;
        matrizBtn[8][3] = btn100;
        matrizBtn[8][4] = btn101;
        matrizBtn[8][5] = btn102;
        matrizBtn[8][6] = btn103;
        matrizBtn[8][7] = btn104;
        matrizBtn[8][8] = btn105;
        matrizBtn[8][9] = btn106;
        matrizBtn[8][10] = btn107;
        matrizBtn[8][11] = btn108;
        matrizBtn[9][0] = btn109;
        matrizBtn[9][1] = btn110;
        matrizBtn[9][2] = btn111;
        matrizBtn[9][3] = btn112;
        matrizBtn[9][4] = btn113;
        matrizBtn[9][5] = btn114;
        matrizBtn[9][6] = btn115;
        matrizBtn[9][7] = btn116;
        matrizBtn[9][8] = btn117;
        matrizBtn[9][9] = btn118;
        matrizBtn[9][10] = btn119;
        matrizBtn[9][11] = btn120;
        matrizBtn[10][0] = btn121;
        matrizBtn[10][1] = btn122;
        matrizBtn[10][2] = btn123;
        matrizBtn[10][3] = btn124;
        matrizBtn[10][4] = btn125;
        matrizBtn[10][5] = btn126;
        matrizBtn[10][6] = btn127;
        matrizBtn[10][7] = btn128;
        matrizBtn[10][8] = btn129;
        matrizBtn[10][9] = btn130;
        matrizBtn[10][10] = btn131;
        matrizBtn[10][11] = btn132;
        matrizBtn[11][0] = btn133;
        matrizBtn[11][1] = btn134;
        matrizBtn[11][2] = btn135;
        matrizBtn[11][3] = btn136;
        matrizBtn[11][4] = btn137;
        matrizBtn[11][5] = btn138;
        matrizBtn[11][6] = btn139;
        matrizBtn[11][7] = btn140;
        matrizBtn[11][8] = btn141;
        matrizBtn[11][9] = btn142;
        matrizBtn[11][10] = btn143;
        matrizBtn[11][11] = btn144;
    }

    private void asignarBotones() {
        for (int i = 0; i < matrizBtn.length; i++) {
            for (int j = 0; j < matrizBtn[i].length; j++) {
                matrizBtn[i][j].setName(i + "," + j);
                matrizBtn[i][j].addActionListener(e -> btnClick(e));
            }
        }
    }

    private void configurarEventos() {
        for (int i = 0; i < matrizBtn.length; i++) {
            for (int j = 0; j < matrizBtn[i].length; j++) {
                matrizBtn[i][j].addMouseListener(new MouseAdapter() {
                    boolean clicked = false;

                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            JButton btn = (JButton) e.getSource();
                            if (clicked) {
                                btn.setBackground(new Color(102, 204, 0));
                                clicked = false;
                            } else {
                                btn.setBackground(Color.RED);
                                clicked = true;
                            }
                        }
                    }
                });
                getContentPane().add(matrizBtn[i][j]);
            }
        }
    }

    private void btnClick(ActionEvent e) {
        if (!juegoIniciado) {
            juegoIniciado = true;
            iniciarTemporizador();
        }
        JButton btn = (JButton) e.getSource();
        String[] coordenada = btn.getName().split(",");
        int posFila = Integer.parseInt(coordenada[0]);
        int posColumna = Integer.parseInt(coordenada[1]);

        juego.seleccionarCasilla(posFila, posColumna);

        if (juego.partidaGanada()) {
            // Código para cuando se gana el juego
        }
    }

    private void iniciarTemporizador() {
        if (temporizador != null) {
            temporizador.stop();
        }
        temporizador = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int minutos = tiempoTranscurrido / 60;
                int segundos = tiempoTranscurrido % 60;

                tiem.setText(minutos + "m " + segundos + "s");
                tiempoTranscurrido++;
            }
        });
        temporizador.setInitialDelay(0);
        temporizador.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn00 = new javax.swing.JButton();
        btn02 = new javax.swing.JButton();
        btn03 = new javax.swing.JButton();
        btn04 = new javax.swing.JButton();
        btn05 = new javax.swing.JButton();
        btn06 = new javax.swing.JButton();
        btn07 = new javax.swing.JButton();
        btn08 = new javax.swing.JButton();
        btn09 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn24 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn19 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn25 = new javax.swing.JButton();
        btn36 = new javax.swing.JButton();
        btn26 = new javax.swing.JButton();
        btn27 = new javax.swing.JButton();
        btn28 = new javax.swing.JButton();
        btn29 = new javax.swing.JButton();
        btn30 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btn32 = new javax.swing.JButton();
        btn33 = new javax.swing.JButton();
        btn34 = new javax.swing.JButton();
        btn35 = new javax.swing.JButton();
        btn37 = new javax.swing.JButton();
        btn48 = new javax.swing.JButton();
        btn38 = new javax.swing.JButton();
        btn39 = new javax.swing.JButton();
        btn40 = new javax.swing.JButton();
        btn41 = new javax.swing.JButton();
        btn42 = new javax.swing.JButton();
        btn43 = new javax.swing.JButton();
        btn44 = new javax.swing.JButton();
        btn45 = new javax.swing.JButton();
        btn46 = new javax.swing.JButton();
        btn47 = new javax.swing.JButton();
        btn60 = new javax.swing.JButton();
        btn81 = new javax.swing.JButton();
        btn61 = new javax.swing.JButton();
        btn82 = new javax.swing.JButton();
        btn72 = new javax.swing.JButton();
        btn83 = new javax.swing.JButton();
        btn62 = new javax.swing.JButton();
        btn85 = new javax.swing.JButton();
        btn63 = new javax.swing.JButton();
        btn64 = new javax.swing.JButton();
        btn96 = new javax.swing.JButton();
        btn86 = new javax.swing.JButton();
        btn65 = new javax.swing.JButton();
        btn87 = new javax.swing.JButton();
        btn66 = new javax.swing.JButton();
        btn88 = new javax.swing.JButton();
        btn67 = new javax.swing.JButton();
        btn89 = new javax.swing.JButton();
        btn68 = new javax.swing.JButton();
        btn90 = new javax.swing.JButton();
        btn69 = new javax.swing.JButton();
        btn91 = new javax.swing.JButton();
        btn49 = new javax.swing.JButton();
        btn70 = new javax.swing.JButton();
        btn92 = new javax.swing.JButton();
        btn50 = new javax.swing.JButton();
        btn71 = new javax.swing.JButton();
        btn93 = new javax.swing.JButton();
        btn51 = new javax.swing.JButton();
        btn73 = new javax.swing.JButton();
        btn94 = new javax.swing.JButton();
        btn52 = new javax.swing.JButton();
        btn84 = new javax.swing.JButton();
        btn53 = new javax.swing.JButton();
        btn74 = new javax.swing.JButton();
        btn54 = new javax.swing.JButton();
        btn55 = new javax.swing.JButton();
        btn95 = new javax.swing.JButton();
        btn75 = new javax.swing.JButton();
        btn76 = new javax.swing.JButton();
        btn56 = new javax.swing.JButton();
        btn77 = new javax.swing.JButton();
        btn57 = new javax.swing.JButton();
        btn78 = new javax.swing.JButton();
        btn58 = new javax.swing.JButton();
        btn79 = new javax.swing.JButton();
        btn59 = new javax.swing.JButton();
        btn80 = new javax.swing.JButton();
        btn108 = new javax.swing.JButton();
        btn129 = new javax.swing.JButton();
        btn109 = new javax.swing.JButton();
        btn130 = new javax.swing.JButton();
        btn120 = new javax.swing.JButton();
        btn131 = new javax.swing.JButton();
        btn110 = new javax.swing.JButton();
        btn133 = new javax.swing.JButton();
        btn111 = new javax.swing.JButton();
        btn112 = new javax.swing.JButton();
        btn134 = new javax.swing.JButton();
        btn113 = new javax.swing.JButton();
        btn135 = new javax.swing.JButton();
        btn114 = new javax.swing.JButton();
        btn136 = new javax.swing.JButton();
        btn115 = new javax.swing.JButton();
        btn137 = new javax.swing.JButton();
        btn116 = new javax.swing.JButton();
        btn138 = new javax.swing.JButton();
        btn117 = new javax.swing.JButton();
        btn139 = new javax.swing.JButton();
        btn97 = new javax.swing.JButton();
        btn118 = new javax.swing.JButton();
        btn140 = new javax.swing.JButton();
        btn98 = new javax.swing.JButton();
        btn119 = new javax.swing.JButton();
        btn141 = new javax.swing.JButton();
        btn99 = new javax.swing.JButton();
        btn121 = new javax.swing.JButton();
        btn142 = new javax.swing.JButton();
        btn100 = new javax.swing.JButton();
        btn132 = new javax.swing.JButton();
        btn101 = new javax.swing.JButton();
        btn122 = new javax.swing.JButton();
        btn102 = new javax.swing.JButton();
        btn103 = new javax.swing.JButton();
        btn143 = new javax.swing.JButton();
        btn123 = new javax.swing.JButton();
        btn124 = new javax.swing.JButton();
        btn104 = new javax.swing.JButton();
        btn125 = new javax.swing.JButton();
        btn105 = new javax.swing.JButton();
        btn126 = new javax.swing.JButton();
        btn106 = new javax.swing.JButton();
        btn127 = new javax.swing.JButton();
        btn107 = new javax.swing.JButton();
        btn128 = new javax.swing.JButton();
        btn144 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblBandera = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        tiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Reiniciar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn00.setBackground(new java.awt.Color(102, 204, 0));
        btn00.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn02.setBackground(new java.awt.Color(102, 204, 0));
        btn02.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn03.setBackground(new java.awt.Color(102, 204, 0));
        btn03.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn04.setBackground(new java.awt.Color(102, 204, 0));
        btn04.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn05.setBackground(new java.awt.Color(102, 204, 0));
        btn05.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn06.setBackground(new java.awt.Color(102, 204, 0));
        btn06.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn07.setBackground(new java.awt.Color(102, 204, 0));
        btn07.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn08.setBackground(new java.awt.Color(102, 204, 0));
        btn08.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn09.setBackground(new java.awt.Color(102, 204, 0));
        btn09.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn10.setBackground(new java.awt.Color(102, 204, 0));
        btn10.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn11.setBackground(new java.awt.Color(102, 204, 0));
        btn11.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn12.setBackground(new java.awt.Color(102, 204, 0));
        btn12.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn13.setBackground(new java.awt.Color(102, 204, 0));
        btn13.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn24.setBackground(new java.awt.Color(102, 204, 0));
        btn24.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn14.setBackground(new java.awt.Color(102, 204, 0));
        btn14.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn15.setBackground(new java.awt.Color(102, 204, 0));
        btn15.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn16.setBackground(new java.awt.Color(102, 204, 0));
        btn16.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn17.setBackground(new java.awt.Color(102, 204, 0));
        btn17.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn18.setBackground(new java.awt.Color(102, 204, 0));
        btn18.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn19.setBackground(new java.awt.Color(102, 204, 0));
        btn19.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn20.setBackground(new java.awt.Color(102, 204, 0));
        btn20.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn21.setBackground(new java.awt.Color(102, 204, 0));
        btn21.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn22.setBackground(new java.awt.Color(102, 204, 0));
        btn22.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn23.setBackground(new java.awt.Color(102, 204, 0));
        btn23.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn25.setBackground(new java.awt.Color(102, 204, 0));
        btn25.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn36.setBackground(new java.awt.Color(102, 204, 0));
        btn36.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn26.setBackground(new java.awt.Color(102, 204, 0));
        btn26.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn27.setBackground(new java.awt.Color(102, 204, 0));
        btn27.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn28.setBackground(new java.awt.Color(102, 204, 0));
        btn28.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn29.setBackground(new java.awt.Color(102, 204, 0));
        btn29.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn30.setBackground(new java.awt.Color(102, 204, 0));
        btn30.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn31.setBackground(new java.awt.Color(102, 204, 0));
        btn31.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn32.setBackground(new java.awt.Color(102, 204, 0));
        btn32.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn33.setBackground(new java.awt.Color(102, 204, 0));
        btn33.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn34.setBackground(new java.awt.Color(102, 204, 0));
        btn34.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn35.setBackground(new java.awt.Color(102, 204, 0));
        btn35.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn37.setBackground(new java.awt.Color(102, 204, 0));
        btn37.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn48.setBackground(new java.awt.Color(102, 204, 0));
        btn48.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn38.setBackground(new java.awt.Color(102, 204, 0));
        btn38.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn39.setBackground(new java.awt.Color(102, 204, 0));
        btn39.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn40.setBackground(new java.awt.Color(102, 204, 0));
        btn40.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn41.setBackground(new java.awt.Color(102, 204, 0));
        btn41.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn42.setBackground(new java.awt.Color(102, 204, 0));
        btn42.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn43.setBackground(new java.awt.Color(102, 204, 0));
        btn43.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn44.setBackground(new java.awt.Color(102, 204, 0));
        btn44.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn45.setBackground(new java.awt.Color(102, 204, 0));
        btn45.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn46.setBackground(new java.awt.Color(102, 204, 0));
        btn46.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn47.setBackground(new java.awt.Color(102, 204, 0));
        btn47.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn60.setBackground(new java.awt.Color(102, 204, 0));
        btn60.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn81.setBackground(new java.awt.Color(102, 204, 0));
        btn81.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn61.setBackground(new java.awt.Color(102, 204, 0));
        btn61.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn82.setBackground(new java.awt.Color(102, 204, 0));
        btn82.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn72.setBackground(new java.awt.Color(102, 204, 0));
        btn72.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn83.setBackground(new java.awt.Color(102, 204, 0));
        btn83.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn62.setBackground(new java.awt.Color(102, 204, 0));
        btn62.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn85.setBackground(new java.awt.Color(102, 204, 0));
        btn85.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn63.setBackground(new java.awt.Color(102, 204, 0));
        btn63.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn64.setBackground(new java.awt.Color(102, 204, 0));
        btn64.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn96.setBackground(new java.awt.Color(102, 204, 0));
        btn96.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn86.setBackground(new java.awt.Color(102, 204, 0));
        btn86.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn65.setBackground(new java.awt.Color(102, 204, 0));
        btn65.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn87.setBackground(new java.awt.Color(102, 204, 0));
        btn87.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn66.setBackground(new java.awt.Color(102, 204, 0));
        btn66.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn88.setBackground(new java.awt.Color(102, 204, 0));
        btn88.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn67.setBackground(new java.awt.Color(102, 204, 0));
        btn67.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn89.setBackground(new java.awt.Color(102, 204, 0));
        btn89.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn68.setBackground(new java.awt.Color(102, 204, 0));
        btn68.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn90.setBackground(new java.awt.Color(102, 204, 0));
        btn90.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn69.setBackground(new java.awt.Color(102, 204, 0));
        btn69.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn91.setBackground(new java.awt.Color(102, 204, 0));
        btn91.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn49.setBackground(new java.awt.Color(102, 204, 0));
        btn49.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn70.setBackground(new java.awt.Color(102, 204, 0));
        btn70.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn92.setBackground(new java.awt.Color(102, 204, 0));
        btn92.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn50.setBackground(new java.awt.Color(102, 204, 0));
        btn50.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn71.setBackground(new java.awt.Color(102, 204, 0));
        btn71.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn93.setBackground(new java.awt.Color(102, 204, 0));
        btn93.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn51.setBackground(new java.awt.Color(102, 204, 0));
        btn51.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn73.setBackground(new java.awt.Color(102, 204, 0));
        btn73.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn94.setBackground(new java.awt.Color(102, 204, 0));
        btn94.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn52.setBackground(new java.awt.Color(102, 204, 0));
        btn52.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn84.setBackground(new java.awt.Color(102, 204, 0));
        btn84.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn53.setBackground(new java.awt.Color(102, 204, 0));
        btn53.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn74.setBackground(new java.awt.Color(102, 204, 0));
        btn74.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn54.setBackground(new java.awt.Color(102, 204, 0));
        btn54.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn55.setBackground(new java.awt.Color(102, 204, 0));
        btn55.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn95.setBackground(new java.awt.Color(102, 204, 0));
        btn95.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn75.setBackground(new java.awt.Color(102, 204, 0));
        btn75.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn76.setBackground(new java.awt.Color(102, 204, 0));
        btn76.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn56.setBackground(new java.awt.Color(102, 204, 0));
        btn56.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn77.setBackground(new java.awt.Color(102, 204, 0));
        btn77.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn57.setBackground(new java.awt.Color(102, 204, 0));
        btn57.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn78.setBackground(new java.awt.Color(102, 204, 0));
        btn78.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn58.setBackground(new java.awt.Color(102, 204, 0));
        btn58.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn79.setBackground(new java.awt.Color(102, 204, 0));
        btn79.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn59.setBackground(new java.awt.Color(102, 204, 0));
        btn59.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn80.setBackground(new java.awt.Color(102, 204, 0));
        btn80.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn108.setBackground(new java.awt.Color(102, 204, 0));
        btn108.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn129.setBackground(new java.awt.Color(102, 204, 0));
        btn129.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn109.setBackground(new java.awt.Color(102, 204, 0));
        btn109.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn130.setBackground(new java.awt.Color(102, 204, 0));
        btn130.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn120.setBackground(new java.awt.Color(102, 204, 0));
        btn120.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn131.setBackground(new java.awt.Color(102, 204, 0));
        btn131.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn110.setBackground(new java.awt.Color(102, 204, 0));
        btn110.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn133.setBackground(new java.awt.Color(102, 204, 0));
        btn133.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn111.setBackground(new java.awt.Color(102, 204, 0));
        btn111.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn112.setBackground(new java.awt.Color(102, 204, 0));
        btn112.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn134.setBackground(new java.awt.Color(102, 204, 0));
        btn134.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn113.setBackground(new java.awt.Color(102, 204, 0));
        btn113.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn135.setBackground(new java.awt.Color(102, 204, 0));
        btn135.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn114.setBackground(new java.awt.Color(102, 204, 0));
        btn114.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn136.setBackground(new java.awt.Color(102, 204, 0));
        btn136.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn115.setBackground(new java.awt.Color(102, 204, 0));
        btn115.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn137.setBackground(new java.awt.Color(102, 204, 0));
        btn137.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn116.setBackground(new java.awt.Color(102, 204, 0));
        btn116.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn138.setBackground(new java.awt.Color(102, 204, 0));
        btn138.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn117.setBackground(new java.awt.Color(102, 204, 0));
        btn117.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn139.setBackground(new java.awt.Color(102, 204, 0));
        btn139.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn97.setBackground(new java.awt.Color(102, 204, 0));
        btn97.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn118.setBackground(new java.awt.Color(102, 204, 0));
        btn118.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn140.setBackground(new java.awt.Color(102, 204, 0));
        btn140.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn98.setBackground(new java.awt.Color(102, 204, 0));
        btn98.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn119.setBackground(new java.awt.Color(102, 204, 0));
        btn119.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn141.setBackground(new java.awt.Color(102, 204, 0));
        btn141.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn99.setBackground(new java.awt.Color(102, 204, 0));
        btn99.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn121.setBackground(new java.awt.Color(102, 204, 0));
        btn121.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn142.setBackground(new java.awt.Color(102, 204, 0));
        btn142.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn100.setBackground(new java.awt.Color(102, 204, 0));
        btn100.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn132.setBackground(new java.awt.Color(102, 204, 0));
        btn132.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn101.setBackground(new java.awt.Color(102, 204, 0));
        btn101.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn122.setBackground(new java.awt.Color(102, 204, 0));
        btn122.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn102.setBackground(new java.awt.Color(102, 204, 0));
        btn102.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn103.setBackground(new java.awt.Color(102, 204, 0));
        btn103.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn143.setBackground(new java.awt.Color(102, 204, 0));
        btn143.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn123.setBackground(new java.awt.Color(102, 204, 0));
        btn123.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn124.setBackground(new java.awt.Color(102, 204, 0));
        btn124.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn104.setBackground(new java.awt.Color(102, 204, 0));
        btn104.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn125.setBackground(new java.awt.Color(102, 204, 0));
        btn125.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn105.setBackground(new java.awt.Color(102, 204, 0));
        btn105.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn126.setBackground(new java.awt.Color(102, 204, 0));
        btn126.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn106.setBackground(new java.awt.Color(102, 204, 0));
        btn106.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn127.setBackground(new java.awt.Color(102, 204, 0));
        btn127.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn107.setBackground(new java.awt.Color(102, 204, 0));
        btn107.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn128.setBackground(new java.awt.Color(102, 204, 0));
        btn128.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        btn144.setBackground(new java.awt.Color(102, 204, 0));
        btn144.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N

        lblBandera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flag-32.png"))); // NOI18N

        btnReiniciar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        tiem.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N
        jLabel1.setText("Tiempo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReiniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBandera)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBandera)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenu1.setText("Juego");

        Reiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reload_32.png"))); // NOI18N
        Reiniciar.setText("Reiniciar");
        jMenu1.add(Reiniciar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn03, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn04, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn05, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn06, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn07, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn08, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn09, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn85, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn86, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn87, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn88, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn89, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn90, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn91, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn92, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn93, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn94, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn95, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn96, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn97, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn98, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn99, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn100, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn101, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn102, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn103, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn104, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn105, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn106, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn107, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn108, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn109, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn110, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn111, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn112, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn113, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn114, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn115, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn116, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn117, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn118, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn119, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn120, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn121, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn122, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn123, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn124, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn125, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn126, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn127, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn128, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn129, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn130, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn131, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn132, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn133, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn134, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn135, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn136, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn137, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn139, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn140, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn141, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn142, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn143, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn138, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn144, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn49, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn58, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn59, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn60, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn65, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn66, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn67, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn68, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn69, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn70, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn71, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn72, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn73, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn74, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn75, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn76, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn77, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn78, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn79, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn80, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn81, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn84, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn03, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn04, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn05, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn06, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn07, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn08, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn09, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btn48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn49, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn58, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn59, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn60, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn65, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn66, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn67, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn68, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn69, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn70, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn71, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn72, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn73, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn74, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn75, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn76, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn77, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn78, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn79, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn80, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn81, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn84, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn85, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn86, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn87, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn88, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn89, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn90, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn91, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn92, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn93, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn94, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn95, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn96, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn97, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn98, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn99, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn100, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn101, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn102, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn103, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn104, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn105, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn106, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn107, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn108, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn109, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn110, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn111, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn112, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn113, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn114, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn115, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn116, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn117, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn118, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn119, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn120, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn121, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn122, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn123, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn124, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn125, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn126, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn127, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn128, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn129, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn130, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn131, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn132, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn133, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn134, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn135, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn136, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn137, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn139, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn140, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn141, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn142, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn143, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn138, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn144, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        if (temporizador != null && temporizador.isRunning()) {
            temporizador.stop();
        }

        tiempoTranscurrido = 0;
        tiem.setText("0");

        juegoIniciado = false;

        juegoNuevo();

        // Restaurar el estado inicial de los botones y establecer el fondo en verde
        for (int i = 0; i < matrizBtn.length; i++) {
            for (int j = 0; j < matrizBtn[i].length; j++) {
                matrizBtn[i][j].setEnabled(true);
                matrizBtn[i][j].setText("");
                matrizBtn[i][j].setBackground(new Color(102, 204, 0));
            }
        }
    }//GEN-LAST:event_btnReiniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Reiniciar;
    private javax.swing.JButton btn00;
    private javax.swing.JButton btn02;
    private javax.swing.JButton btn03;
    private javax.swing.JButton btn04;
    private javax.swing.JButton btn05;
    private javax.swing.JButton btn06;
    private javax.swing.JButton btn07;
    private javax.swing.JButton btn08;
    private javax.swing.JButton btn09;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn100;
    private javax.swing.JButton btn101;
    private javax.swing.JButton btn102;
    private javax.swing.JButton btn103;
    private javax.swing.JButton btn104;
    private javax.swing.JButton btn105;
    private javax.swing.JButton btn106;
    private javax.swing.JButton btn107;
    private javax.swing.JButton btn108;
    private javax.swing.JButton btn109;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn110;
    private javax.swing.JButton btn111;
    private javax.swing.JButton btn112;
    private javax.swing.JButton btn113;
    private javax.swing.JButton btn114;
    private javax.swing.JButton btn115;
    private javax.swing.JButton btn116;
    private javax.swing.JButton btn117;
    private javax.swing.JButton btn118;
    private javax.swing.JButton btn119;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn120;
    private javax.swing.JButton btn121;
    private javax.swing.JButton btn122;
    private javax.swing.JButton btn123;
    private javax.swing.JButton btn124;
    private javax.swing.JButton btn125;
    private javax.swing.JButton btn126;
    private javax.swing.JButton btn127;
    private javax.swing.JButton btn128;
    private javax.swing.JButton btn129;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn130;
    private javax.swing.JButton btn131;
    private javax.swing.JButton btn132;
    private javax.swing.JButton btn133;
    private javax.swing.JButton btn134;
    private javax.swing.JButton btn135;
    private javax.swing.JButton btn136;
    private javax.swing.JButton btn137;
    private javax.swing.JButton btn138;
    private javax.swing.JButton btn139;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn140;
    private javax.swing.JButton btn141;
    private javax.swing.JButton btn142;
    private javax.swing.JButton btn143;
    private javax.swing.JButton btn144;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn24;
    private javax.swing.JButton btn25;
    private javax.swing.JButton btn26;
    private javax.swing.JButton btn27;
    private javax.swing.JButton btn28;
    private javax.swing.JButton btn29;
    private javax.swing.JButton btn30;
    private javax.swing.JButton btn31;
    private javax.swing.JButton btn32;
    private javax.swing.JButton btn33;
    private javax.swing.JButton btn34;
    private javax.swing.JButton btn35;
    private javax.swing.JButton btn36;
    private javax.swing.JButton btn37;
    private javax.swing.JButton btn38;
    private javax.swing.JButton btn39;
    private javax.swing.JButton btn40;
    private javax.swing.JButton btn41;
    private javax.swing.JButton btn42;
    private javax.swing.JButton btn43;
    private javax.swing.JButton btn44;
    private javax.swing.JButton btn45;
    private javax.swing.JButton btn46;
    private javax.swing.JButton btn47;
    private javax.swing.JButton btn48;
    private javax.swing.JButton btn49;
    private javax.swing.JButton btn50;
    private javax.swing.JButton btn51;
    private javax.swing.JButton btn52;
    private javax.swing.JButton btn53;
    private javax.swing.JButton btn54;
    private javax.swing.JButton btn55;
    private javax.swing.JButton btn56;
    private javax.swing.JButton btn57;
    private javax.swing.JButton btn58;
    private javax.swing.JButton btn59;
    private javax.swing.JButton btn60;
    private javax.swing.JButton btn61;
    private javax.swing.JButton btn62;
    private javax.swing.JButton btn63;
    private javax.swing.JButton btn64;
    private javax.swing.JButton btn65;
    private javax.swing.JButton btn66;
    private javax.swing.JButton btn67;
    private javax.swing.JButton btn68;
    private javax.swing.JButton btn69;
    private javax.swing.JButton btn70;
    private javax.swing.JButton btn71;
    private javax.swing.JButton btn72;
    private javax.swing.JButton btn73;
    private javax.swing.JButton btn74;
    private javax.swing.JButton btn75;
    private javax.swing.JButton btn76;
    private javax.swing.JButton btn77;
    private javax.swing.JButton btn78;
    private javax.swing.JButton btn79;
    private javax.swing.JButton btn80;
    private javax.swing.JButton btn81;
    private javax.swing.JButton btn82;
    private javax.swing.JButton btn83;
    private javax.swing.JButton btn84;
    private javax.swing.JButton btn85;
    private javax.swing.JButton btn86;
    private javax.swing.JButton btn87;
    private javax.swing.JButton btn88;
    private javax.swing.JButton btn89;
    private javax.swing.JButton btn90;
    private javax.swing.JButton btn91;
    private javax.swing.JButton btn92;
    private javax.swing.JButton btn93;
    private javax.swing.JButton btn94;
    private javax.swing.JButton btn95;
    private javax.swing.JButton btn96;
    private javax.swing.JButton btn97;
    private javax.swing.JButton btn98;
    private javax.swing.JButton btn99;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBandera;
    private javax.swing.JButton tiem;
    // End of variables declaration//GEN-END:variables
}
