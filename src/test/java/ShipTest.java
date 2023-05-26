import org.junit.Before;
import org.junit.Test;



import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShipTest {

    Ship ship1;

    @Before
    public void before() {
        ship1 = new Ship("3:3,3:5");
    }

    @Test
    public void allCoordinates(){
        ArrayList<String> allShipCoordinates = new ArrayList<String>();
        allShipCoordinates.add("3:3");
        allShipCoordinates.add("3:5");
        allShipCoordinates.add("3:4");
        assertEquals(allShipCoordinates,ship1.createShip());}

    @Test
    public void canHitShip(){
        assertEquals(true ,ship1.checkHit("3:3"));
        assertEquals(true ,ship1.checkHit("3:4"));
        assertEquals(true ,ship1.checkHit("3:5"));
        assertEquals(false ,ship1.checkHit("3:6"));
    }



}
