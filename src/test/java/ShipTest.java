import org.junit.Before;
import org.junit.Test;



import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShipTest {

    Ship ship1;
    Ship ship2;

    ArrayList allShipCoordinates;

    ArrayList guesses;

    ArrayList ships;


    @Before
    public void before() {
        ship1 = new Ship("3:3,3:5");
        ship2 = new Ship("1:1,1:2");
        allShipCoordinates = new ArrayList<String>();
        guesses = new ArrayList<String>();
        ships = new ArrayList<Ship>();
        ships.add(ship1);
        ships.add(ship2);
        guesses.add("1:1");
        guesses.add("1:2");
        guesses.add("3:3");
        allShipCoordinates.add("3:3");
        allShipCoordinates.add("3:5");
        allShipCoordinates.add("3:4");
    }

    @Test
    public void allCoordinates(){
        assertEquals(allShipCoordinates,ship1.createShip());}

    @Test
    public void canHitShip(){
        assertEquals(true ,ship1.checkHit("3:3"));
        assertEquals(true ,ship1.checkHit("3:4"));
        assertEquals(true ,ship1.checkHit("3:5"));
        assertEquals(false ,ship1.checkHit("3:6"));
    }


    @Test
    public void canPlay(){
        assertEquals(1 ,ship1.play(ships,guesses));
    }
}
