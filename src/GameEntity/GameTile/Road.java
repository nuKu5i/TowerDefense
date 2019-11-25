package GameEntity.GameTile;

public class Road {
    private static int blockSize = 64;
    public static final Position[] wayPoints = new Position[]{
            new Position(1 * blockSize, 10 * blockSize ),
            new Position(1 * blockSize, 4  * blockSize ),
            new Position(3 * blockSize, 4 * blockSize ),
            new Position(3 * blockSize, 1 * blockSize ),
            new Position(7 * blockSize, 1 * blockSize ),
            new Position(7 * blockSize, 6 * blockSize ),
            new Position(10 * blockSize, 6 * blockSize ),
            new Position(10 * blockSize, 3 * blockSize ),
            new Position(14 * blockSize, 3 * blockSize )
    };
}
