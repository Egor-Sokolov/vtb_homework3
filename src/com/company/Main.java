package com.company;
/*  1. Создайте исключения: MyArraySizeException (неправильный размер массива), и
 MyArrayDataException (в ячейке массива лежит что-то не то);
    2. Напишите метод, на вход которого подаётся двумерный строковый массив (String[][]) размером 4×4.
При подаче массива другого размера необходимо бросить исключение  MyArraySizeException.
    3. Далее метод должен пройтись по всем элементам массива, преобразовать в int и
        просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
        ячейке лежит символ или текст вместо числа), должно быть брошено исключение
        MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные. Расчет
        данных для этой матрицы прекращается.
        4. В методе main() нужно вызвать полученный метод, обработать возможные исключения
        MySizeArrayException и MyArrayDataException и вывести результат расчёта. */



public class Main {

    public static void main(String[] args) {
        String[][] array4x4 =
                {{"1", "2", "3", "4"}
                        , {"5", "6", "7", "8"}
                        , {"9", "10", "11", "12"}
                        , {"13", "14", "15", "16"}};

        String[][] arrayNot4x4 =
                {{"1", "2", "3"}
                        , {"5", "6", "7"}
                        , {"9", "10", "11"}
                        , {"13", "14", "15"}};

        String[][] arraySymbol4x4 =
                {{"1", "2", "3", "4"}
                        , {"5", "6", "7", "8"}
                        , {"9", "1ui0", "11", "12"}
                        , {"13", "14", "15", "16"}};

        array4x4Method(array4x4);
        try {
            array4x4Method(arrayNot4x4);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());

        }
        try {
            array4x4Method(arraySymbol4x4);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
        public static void array4x4Method (String[][] arr) {

            int result = 0;
            int m_result = 0;
            for (Object[] m : arr) {
                result += m.length;
                m_result = m.length;
            }
            if( m_result!=4 && result != 16 ) throw new MyArraySizeException();

            System.out.println("Длина строки и размер массива " +  m_result +"," +result);
           int[][] numArr = new int[4][4];
           int sumArr = 0;
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr.length; j++){
                    try {
                        numArr[i][j] = Integer.parseInt(arr[i][j]);
                    }
                    catch (NumberFormatException e){
                        throw new MyArrayDataException(i,j,arr);
                    }

                    sumArr +=numArr[i][j];
                }
            }
            System.out.println("Сумма элементов массива = " + sumArr);
        }
}
