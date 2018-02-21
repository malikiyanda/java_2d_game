/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.Game;
import Survivor.input.Mouse;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author miyan
 */
public class MenuState extends StateManager {

    private Mouse mouse;
    private Game game;
    public  StateManager gameState;
    
    
    public MenuState(Mouse mouse){
        
        this.mouse = mouse;
        gameState = new GameState();
    }
    
    
    
    
    @Override
    public void update() {
        System.out.println(mouse.getXMouse() + "    " + mouse.getYMouse());
        if(mouse.isLeftPressed())
            StateManager.setState(this.gameState);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0, 0, 1000, 800);
        g.setColor(Color.red);
        g.fillRect(mouse.getXMouse(), mouse.getYMouse(), 8, 8);
    }
    
}
