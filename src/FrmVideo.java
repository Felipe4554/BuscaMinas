
import Controlador.TableroBuscaminas;
import Vista.FrmJuego;
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
public class FrmVideo extends javax.swing.JFrame {

    private javax.swing.Timer temporizador;

    private boolean juegoIniciado = false;
    private int tiempoTranscurrido = 0;

    int numFilas = 12;
    int numColumnas = 12;
    int numMinas = 30;

    JButton[][] matrizBtn;
    TableroBuscaminas tableroBuscaminas;

    /**
     * Creates new form FrmJuego
     */
    public FrmVideo() {
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
        cargarMatrizBtn();
        crearTableroBuscaminas();
        repaint();
    }

    private void crearTableroBuscaminas() {
        tableroBuscaminas = new TableroBuscaminas(numFilas, numColumnas, numMinas);

        tableroBuscaminas.setPartidaPerdidaListener(new PartidaPerdidaListener() {
            @Override
            public void partidaPerdida(List<Casilla> t) {
                for (Casilla casillaConMina : t) {
                    matrizBtn[casillaConMina.getPosFila()][casillaConMina.getPosColumna()].setText("*");
                }
            }
        });

        tableroBuscaminas.setPartidaGanadaListener(new PartidaGanadaListener() {
            @Override
            public void partidaGanada(List<Casilla> t) {
                for (Casilla casillaConMina : t) {
                    matrizBtn[casillaConMina.getPosFila()][casillaConMina.getPosColumna()].setText(":)");
                }
            }
        });

        tableroBuscaminas.setCasillaAbiertaListener(new CasillaAbiertaListener() {
            @Override
            public void casillaAbierta(Casilla t) {
                matrizBtn[t.getPosFila()][t.getPosColumna()].setEnabled(false);
                matrizBtn[t.getPosFila()][t.getPosColumna()]
                        .setText(t.getNumMinasAlrededor() == 0 ? "" : t.getNumMinasAlrededor() + "");
            }
        });
    }

    private void cargarMatrizBtn() {
        inicializarMatrizBtn();
        asignarBotones();
        configurarEventos();
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
            }
        }
    }

    private void btnClick(ActionEvent e) {
        if (!juegoIniciado) {
            juegoIniciado = true; // Marcar el juego como iniciado
            iniciarTemporizador();
        }
        JButton btn = (JButton) e.getSource();
        String[] coordenada = btn.getName().split(",");
        int posFila = Integer.parseInt(coordenada[0]);
        int posColumna = Integer.parseInt(coordenada[1]);
        //JOptionPane.showMessageDialog(rootPane, posFila+","+posColumna);
        tableroBuscaminas.seleccionarCasilla(posFila, posColumna);

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmVideo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
