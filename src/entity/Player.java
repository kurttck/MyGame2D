package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction ="down";
    }

    public void getPlayerImage() {
        try{
            up = ImageIO.read(getClass().getResourceAsStream("/player/mage_up.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/mage_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/mage_up_2.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/player/mage_down.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/mage_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/mage_down_2.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/player/mage_left.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/mage_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/mage_left_2.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/player/mage_right.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/mage_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/mage_right_2.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {


        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed) {
                direction = "up";
                y -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                y += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                x -= speed;
            } else if (keyH.rightPressed) {

                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if(spriteCounter>8){
                if(spriteStep ==0){
                    spriteStep = 1;
                    spriteNum = 2;
                }else if(spriteStep == 1){
                    spriteStep = 2;
                    spriteNum = 1;
                } else if (spriteStep == 2){
                    spriteStep = 3;
                    spriteNum = 3;
                }else if (spriteStep == 3){
                    spriteStep = 0;
                    spriteNum = 1;
                }

                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2d) {

        //g2d.setColor(Color.white);

        //Dibuja un rectangulo
        //g2d.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch (direction) {
            case "up":
                if(spriteNum == 1) {
                    image = up;
                }
                if (spriteNum == 2) {
                    image = up1;
                }
                if (spriteNum == 3) {
                    image = up2;
                }
                break;
                case "down":
                if(spriteNum == 1) {
                    image = down;
                }
                if (spriteNum == 2) {
                    image = down1;
                }
                if (spriteNum == 3) {
                    image = down2;
                }
                break;
                case "left":
                if(spriteNum == 1) {
                    image = left;
                }
                if (spriteNum == 2) {
                    image = left1;
                }
                if (spriteNum == 3) {
                    image = left2;
                }
                break;
                case "right":
                if(spriteNum == 1) {
                    image = right;
                }
                if (spriteNum == 2) {
                    image = right1;
                }
                if (spriteNum == 3) {
                    image = right2;
                }
                break;


        }
        g2d.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
