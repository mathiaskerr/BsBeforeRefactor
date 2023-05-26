import java.util.ArrayList;

public class Ship {

    private String coordinates;



    public Ship(String coordinates) {
        this.coordinates = coordinates;
    }


    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }



    public ArrayList<String> createShip() {
        ArrayList<String> allShipCoordinates = new ArrayList<String>();
        String[] coordinates = getCoordinates().split(",");
        String[] point1 = coordinates[0].split(":");
        String[] point2 = coordinates[1].split(":");

        for(int i=0; i< coordinates.length; i++) {
            allShipCoordinates.add(coordinates[i]);
        }


        int ref = 0;
        String p = "";
        if(Integer.parseInt(point1[0]) == Integer.parseInt(point2[0])){
            if(Integer.parseInt(point1[1]) > Integer.parseInt(point2[1])){
                ref = Integer.parseInt(point1[1]) - Integer.parseInt(point2[1])- 1;
                for(int i=0; i< ref; i++) {

                    String x = point1[0] +":";
            int y = Integer.parseInt(point1[1]) - ref + i;
            String z = Integer.toString(y);
                 p = x + z;
                 allShipCoordinates.add(p);
        }

            } else {
                ref = Integer.parseInt(point2[1]) - Integer.parseInt(point1[1]) - 1;


                for (int i = 0; i < ref; i++) {

                    String x = point1[0] + ":";
                    int y = Integer.parseInt(point2[1]) - ref + i;
                    String z = Integer.toString(y);
                    p = x + z;
                    allShipCoordinates.add(p);

                }
            }
//                the big else
        } else {
            if(Integer.parseInt(point1[0]) > Integer.parseInt(point2[0])){
                ref = Integer.parseInt(point1[0]) - Integer.parseInt(point2[0])- 1;
                for(int i=0; i< ref; i++) {

                    String x =  ":" + point1[1] ;
                    int y = Integer.parseInt(point1[0]) - ref + i;
                    String z = Integer.toString(y);
                    p = z + x;
                    allShipCoordinates.add(p);
                }

            } else { ref = Integer.parseInt(point2[0]) - Integer.parseInt(point1[0])- 1;

                for(int i=0; i< ref; i++) {

                    String x =   ":" + point1[1];
                    int y = Integer.parseInt(point2[0]) - ref + i;
                    String z = Integer.toString(y);
                    p =  z + x;
                    allShipCoordinates.add(p);
                }
            }
        }

    return allShipCoordinates;
    }

    public boolean checkHit(String guess) {
        ArrayList<String> ship = createShip();
//        return if guess is ship
        return ship.contains(guess);

    }


    public int play(ArrayList ships, ArrayList guesses) {
        int shipsSunk= 0;
        int shipsRemaining= 0;
        ArrayList<String> currentShip = new ArrayList<String>();

        for(int i =0; i < ships.size() ; i ++){
               Ship ship = (Ship) ships.get(i);
              currentShip = ship.createShip();
              for(int j =0; j < guesses.size() ; j ++){
                  if(currentShip.contains(guesses.get(j))){
                      currentShip.remove(guesses.get(j));

                  }

              }
              if(currentShip.size() == 0){shipsSunk += 1;}


        }

        return shipsSunk;
    }
}



