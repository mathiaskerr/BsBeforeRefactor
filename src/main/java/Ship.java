import java.util.ArrayList;

public class Ship {
    private String coordinates;

    public Ship(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public ArrayList<String> createShip() {
        ArrayList<String> allShipCoordinates = new ArrayList<String>();
        String[] coordinates = getCoordinates().split(",");
        String[] point1 = coordinates[0].split(":");
        String[] point2 = coordinates[1].split(":");

        for(String coordinate : coordinates) {
            allShipCoordinates.add(coordinate);
        }

        int ref;
        String newCoordinate = "";
        if(Integer.parseInt(point1[0]) == Integer.parseInt(point2[0])){
            if(Integer.parseInt(point1[1]) > Integer.parseInt(point2[1])){
                ref = Integer.parseInt(point1[1]) - Integer.parseInt(point2[1])- 1;
                for(int i=0; i< ref; i++) {
                    String x = point1[0] +":";
                    int y = Integer.parseInt(point1[1]) - ref + i;
                    String z = Integer.toString(y);
                    newCoordinate = x + z;
                    allShipCoordinates.add(newCoordinate);
                }
        } else {
                ref = Integer.parseInt(point2[1]) - Integer.parseInt(point1[1]) - 1;
                for (int i = 0; i < ref; i++) {
                    String x = point1[0] + ":";
                    int y = Integer.parseInt(point2[1]) - ref + i;
                    String z = Integer.toString(y);
                    newCoordinate = x + z;
                    allShipCoordinates.add(newCoordinate);
                }
            }
        } else {
            if(Integer.parseInt(point1[0]) > Integer.parseInt(point2[0])){
                ref = Integer.parseInt(point1[0]) - Integer.parseInt(point2[0])- 1;
                for(int i=0; i< ref; i++) {
                    String x =  ":" + point1[1] ;
                    int y = Integer.parseInt(point1[0]) - ref + i;
                    String z = Integer.toString(y);
                    newCoordinate = z + x;
                    allShipCoordinates.add(newCoordinate);
                }
            } else { ref = Integer.parseInt(point2[0]) - Integer.parseInt(point1[0])- 1;
                for(int i=0; i< ref; i++) {
                    String x =   ":" + point1[1];
                    int y = Integer.parseInt(point2[0]) - ref + i;
                    String z = Integer.toString(y);
                    newCoordinate =  z + x;
                    allShipCoordinates.add(newCoordinate);
                }
            }
        }

    return allShipCoordinates;
    }

    public boolean checkHit(ArrayList ship,Object guess) {
        return ship.contains(guess);
    }

    public String play(ArrayList ships, ArrayList guesses) {
        int shipsSunk= 0;
        int shipsRemaining= 0;
        ArrayList<String> currentShip = new ArrayList<String>();

        for(int i =0; i < ships.size() ; i ++){
               Ship ship = (Ship) ships.get(i);
              currentShip = ship.createShip();
              for(int j =0; j < guesses.size() ; j ++){
                  if(checkHit(currentShip,guesses.get(j))){
                      currentShip.remove(guesses.get(j));
                  }
              }
              if(currentShip.size() == 0){shipsSunk += 1;
              }else{
                  shipsRemaining += 1;}
        }
        return ("You sunk " + Integer.toString(shipsSunk) +" ships and " + Integer.toString(shipsRemaining) + " remains");
    }
}




