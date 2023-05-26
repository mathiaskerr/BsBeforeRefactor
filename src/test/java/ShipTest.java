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
//        create new ships to test
        ship1 = new Ship("3:3,3:5");
        ship2 = new Ship("1:1,1:2");
        allShipCoordinates = new ArrayList<String>();
        guesses = new ArrayList<String>();
        ships = new ArrayList<Ship>();
//        add ships here
        ships.add(ship1);
        ships.add(ship2);
//        add guesses for testing
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
        assertEquals(true ,ship1.checkHit(ship1.createShip(),"3:3"));
        assertEquals(true ,ship1.checkHit(ship1.createShip(),"3:4"));
        assertEquals(true ,ship1.checkHit(ship1.createShip(),"3:5"));
        assertEquals(false ,ship1.checkHit(ship1.createShip(),"3:6"));
        assertEquals(false ,ship2.checkHit(ship2.createShip(),"3:6"));
    }

    @Test
    public void canPlay(){
        assertEquals("You sunk 1 ships and 1 remains" ,ship1.play(ships,guesses));
    }
}
