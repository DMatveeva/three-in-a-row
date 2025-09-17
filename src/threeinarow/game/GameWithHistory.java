package threeinarow.game;


/**
 * АТД
 */
public abstract class GameWithHistory extends AbstractGame {

//    private final CommandHistory commandHistory;
//
//    protected GameWithHistory() {
//        GameMatrixFactory gameMatrixFactory = GameMatrixFactory.getInstance();
//        this.matrix = gameMatrixFactory.createMatrix();
//        this.commandHistory = new CommandHistory();
//    }
//
//    @Override
//    public void showStepHistory() {
//
//    }
//
//    Command getLastCommand() {
//        return commandHistory.peek();
//    }
//
//    //команды
//    @Override
//    public void enterCoordinates() {
//        Scanner input = new Scanner(System.in);
//        String s = input.nextLine();
//        boolean matches = s.matches(COORDINATE_INPUT_PATTERN);
//        if (!matches) {
//            enterCoordinatesStatus = ENTER_COORDINATES_ERR;
//            return;
//        }
//        String[] parts = s.split(" ");
//        String from = parts[0];
//        String to = parts[1];
//        Command swap = CommandFactory.getInstance().createSwapCommand(matrix, Coordinate.valueOf(from), Coordinate.valueOf(to));
//        commandHistory.push(swap);
////        if(matrix.possibleToswap = ERR) {
////            enterCoordinatesStatus = ENTER_COORDINATES_ERR;
////        }
////        enterCoordinatesStatus = ENTER_COORDINATES_OK;
//    }
}
