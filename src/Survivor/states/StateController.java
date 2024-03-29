/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survivor.states;

import Survivor.Enums;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author miyan
 */
public class StateController {
    
    private Map<String, State>map;
    private State currentState;
    private Enums id;
    
    private boolean Pause=false;
    private boolean up=false, W=false, down=false, S=false, keyClick=false;

    
    public StateController(Enums id){
        this.id = id;
        map = new HashMap<String, State>();
    }
    
    
    public void addState(State state){
        map.put(state.getName().toUpperCase(), state);
        state.init();
        if(currentState == null){
            state.enter();
            currentState = state;    
       }
    }
    
    public void setState(String name){
        State state = map.get(name.toUpperCase());
        if(state == null){ //error avoidence 
            System.err.println("State <" + name + "> does not exisit!");
            return;
        }
        currentState.exit();
        state.enter();
        currentState = state;
        
        
    }
    
    public void update(){
        currentState.update(this);
    }
    
    public void render(Graphics g){
        currentState.render(g);
    }
    
    
//Getters and setters 
    public Enums getId() {
        return id;
    }

    public void setId(Enums id) {
        this.id = id;
    }
    
    public State getCurrentState() {
        return currentState;
    }
    
    public boolean isPause() {
        return Pause;
    }

    public void setPause(boolean Pause) {
        this.Pause = Pause;
    }
    
    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isW() {
        return W;
    }

    public void setW(boolean W) {
        this.W = W;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isS() {
        return S;
    }

    public void setS(boolean S) {
        this.S = S;
    }
    
    public boolean isKeyClick() {
        return keyClick;
    }

    public void setKeyClick(boolean keyClick) {
        this.keyClick = keyClick;
    }
     
}
