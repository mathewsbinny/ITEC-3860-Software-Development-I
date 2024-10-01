package controller;

/**
 * class: Direction.java
 * @author: Mathews Binny
 * @version: 1.0
 * course: ITEC 3860
 * written: 11 March 2024
 * purpose: Contains the logic for the Direction enum
 */
public enum Direction {
    NORTH("N","NORTH"),
    SOUTH("S","SOUTH"),
    WEST("W","WEST"),
    EAST("E","EAST"),
    UP("U","UP"),
    DOWN("D","DOWN");

    Direction(String directionCode, String directionValue) {
        this.directionCode = directionCode;
        this.directionValue = directionValue;
    }

    private String directionCode;
    private String directionValue;

    public static Direction getDirectionEnumFromDirectionStringValue(String directionValue){
        for (Direction direction: Direction.values()){
            if(direction.getDirectionValue().equalsIgnoreCase(directionValue)){
                return direction;
            }
        }
        return null;
    }

    public static Direction getDirectionEnumByCodeOrValue(String inputValue) {
        if(inputValue!=null && inputValue.length()>0){
            for(Direction direction:Direction.values()){
                if(inputValue.equals(direction.getDirectionValue())
                        || inputValue.equals(direction.getDirectionValue().substring(0,1))){
                    return direction;
                }
            }
        }
        System.out.println("Please enter a valid value for direction. "+inputValue+" is not within the possible list of directions");
        return null;
    }

    public String getDirectionCode() {
        return directionCode;
    }
    public void setDirectionCode(String directionCode) {
        this.directionCode = directionCode;
    }
    public String getDirectionValue() {
        return directionValue;
    }
    public void setDirectionValue(String directionValue) {
        this.directionValue = directionValue;
    }
}
