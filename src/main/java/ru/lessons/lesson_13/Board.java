/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lessons.lesson_13;

/**
 *
 * @author userr
 */
public interface Board {
    
    /* Draws board  from entry array of cells
    @param cells array of cells
    */
    void drawBoard(Cell[][] cells);
    
    /* Draws cells
    @param x horizontal position
    @param y vertical position
    */ 
    void drawCell(int x, int y);
   
    /*
    Draws explosion of all the bombs
    */
    void drawBang();
    
    /*
    draws congratulations
    */
    void drawCongratulations();
}
