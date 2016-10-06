package ru.lessons.lesson_13.gui;

import ru.lessons.lesson_13.Cell;

import java.awt.*;

/**
 * Created by userr on 10/6/2016.
 */
public class GUICell implements Cell<Graphics> {

    public boolean isBomb() {
        return false;
    }

    public boolean isSuggestedBomb() {
        return false;
    }

    public boolean isSuggestedEmpty() {
        return false;
    }

    public void suggestEmpty() {

    }

    public void suggestBomb() {

    }

    public void draw(Graphics paint, boolean real) {

    }
}
