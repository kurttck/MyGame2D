package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 title
    final int scale = 3; // Factor de escala para aumentar el tamaño

    public final int tileSize= originalTileSize*scale; //48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol; //768 px
    final int screenHeight = tileSize*maxScreenRow; //576 px

    // Configuración de FPS (fotogramas por segundo)
    int FPS = 60;

    // Hilo para el juego y controlador de teclas
    Thread gameThread;
    KeyHandler keYH = new KeyHandler();
    Player player = new Player(this, keYH);

    // Posición inicial y velocidad del jugador
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;



    public GamePanel(){

        // Configura el tamaño preferido del panel a las dimensiones dadas por screenWidth y screenHeight
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));

        // Establece el color de fondo del panel en negro
        this.setBackground(Color.black);

        // Activa el "doble buffer" para reducir el parpadeo en la animación, lo cual es útil en gráficos de juegos
        this.setDoubleBuffered(true);

        // Agrega el KeyListener para detectar entradas del teclado y hace que el panel sea "focusable"
        this.addKeyListener(keYH);
        this.setFocusable(true);
    }

    // Inicia el hilo del juego
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; //0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                //1 Update: actualiza la informacion de la posicion del jugador
                update();

                //2 Draw: dibuja la informacion en la pantalla(se llama repaint al paintComponent)
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }


    // Actualiza la posición del jugador en función de las teclas presionadas
    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //Convierte a Graphics2D
        Graphics2D g2d = (Graphics2D) g;


        player.draw(g2d);

        //Liberar recursos
        g2d.dispose();
    }
}
