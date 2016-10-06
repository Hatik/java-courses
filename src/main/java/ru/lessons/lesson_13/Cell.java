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
public interface Cell<T> {
    
    boolean isBomb();
    
    boolean isSuggestedBomb();
    
    boolean isSuggestedEmpty();
    
    void suggestEmpty();
    
    void suggestBomb();
    
    void draw(T paint, boolean real);
}
