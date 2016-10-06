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
public interface UserAction {
    
    void initGame();
    
    void select(int x, int y, boolean bomb);
}
