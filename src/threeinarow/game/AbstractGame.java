package threeinarow.game;

/**
 * АТД
 */
public abstract class AbstractGame {

    public final static int ENTER_COORDINATES_NIL = 0; //начало раунда, координаты не введены
    public final static int ENTER_COORDINATES_OK = 1; //координаты введены успешно
    public final static int ENTER_COORDINATES_ERR = 2; //неверный формат ввода

    public final static int EXECUTE_ROUND_OK = 1; //фигуры исчезли
    public final static int EXECUTE_ROUND_ERR = 2; //игра закончена

    int enterCoordinatesStatus;
    int executeRoundStatus = EXECUTE_ROUND_OK;


    AbstractGame() {
    }

    //запросы
    public abstract void showStepHistory();

    public abstract void getFiguresAfterRound();

    //команды
    //постусловие: введены корректные координаты клеток матрицы
    public abstract void enterCoordinates();

    //постусловие: выполнен раунд игры: клетки поменялись, исчезли, заполнились новыми значениями пока не осталось больше фигур
    public abstract void executeRound();


    public int getEnterCoordinatesStatus() {
        return enterCoordinatesStatus;
    }
    public int getExecuteRoundStatus() {
        return executeRoundStatus;
    }
}
