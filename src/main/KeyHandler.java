package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Clase para controlar las teclas pulsadas
public class KeyHandler implements KeyListener {

    // Variables para rastrear el estado de las teclas de dirección (W, A, S, D)
    public boolean upPressed, downPressed, leftPressed, rightPressed;


    // Método que se ejecuta cuando se escribe (tipo) una tecla (no se usa en este caso)

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // Método que se ejecuta cuando se presiona una tecla
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // Obtiene el código de la tecla presionada

        // Verifica si la tecla W,S, A o D está presionada
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }

    }

    // Método que se ejecuta cuando se suelta una tecla
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); // Obtiene el código de la tecla soltada

        // Verifica si la tecla W fue soltada y desactiva la variable 'upPressed'
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        // Verifica si la tecla S fue soltada y desactiva la variable 'downPressed'
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        // Verifica si la tecla A fue soltada y desactiva la variable 'leftPressed'
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        // Verifica si la tecla D fue soltada y desactiva la variable 'rightPressed'
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
