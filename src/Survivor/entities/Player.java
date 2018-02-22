/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.entities;

import Survivor.GameHandler;
import Survivor.entitiesManager.Entities;
import Survivor.entitiesManager.EntityHandler;
import Survivor.entitiesManager.ID;
import Survivor.images.Images;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author miyan
 */
public class Player extends Entities {

    private EntityHandler EH;
    private GameHandler GH;
    
    public Player(int x, int y, ID ID, GameHandler GH, EntityHandler EH) {
        super(ID, x, y, GH);
        
        this.EH = EH;
        this.GH = GH;
        
    }

    @Override
    public void update() {
        x += velX;
        y += velY;
        
        
        
        getInput();        
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.nakedPlayer, x, y, null);
       
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
    
    private void getInput(){
        
        //Movement Actions
        if(EH.isDown()) velY = 5;
        else if(!EH.isUp()) velY = 0;
        
        if(EH.isUp()) velY = -5;
        else if(!EH.isDown()) velY = 0;
        
        if(EH.isRight()) velX = 5;
        else if(!EH.isLeft()) velX = 0;
        
        if(EH.isLeft()) velX = -5;
        else if(!EH.isRight()) velX = 0;         
    
    }
    
    
}

