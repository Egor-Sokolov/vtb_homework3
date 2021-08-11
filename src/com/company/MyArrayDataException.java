package com.company;

public class MyArrayDataException extends  MyException{

    private int row;
    private int column;
    private Object value;

    public MyArrayDataException(int row, int column, Object [][] array) {
        super("Одна ошибка и ты ошибся в этой ячейке неправильный тип данных. Invalid  data in array["+ row +"]["+ column +"] Неправильный элемент="  + array[row][column] );
        this.row = row;
        this.column = column;
        this.value = array[row][column];
    }
}
