package ru.lessons.lesson_13.logics;

import ru.lessons.lesson_13.Cell;
import ru.lessons.lesson_13.SaperLogic;

/**
 * Created by userr on 10/6/2016.
 */
public class Easy implements SaperLogic {
    private Cell[][] cells;

    @Override
    public void loadBoard(Cell[][] cells) {
        this.cells = cells;
    }

    @Override
    public boolean shouldBang(int x, int y) {
        final Cell selected = this.cells[x][y];
        return selected.isBomb() && !selected.isSuggestedBomb();
    }

    @Override
    public boolean finish() {
        boolean finish = false;
        for(Cell[] row : cells)
        {
            for(Cell cell : row)
            {
                finish = ((cell.isSuggestedBomb()  && cell.isBomb()) ||
                        (cell.isSuggestedEmpty() && !cell.isBomb()));
            }
        }
        return finish;
    }

    @Override
    public void suggest(int x, int y, boolean bomb) {
        if (bomb){
            this.cells[x][y].suggestBomb();
        }
        else{
            this.cells[x][y].suggestEmpty();
        }
    }
}
