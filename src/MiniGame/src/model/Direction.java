package model;

/*
An enum type is a special data type that enables for a variable to be a set of predefined constants.
The variable must be equal to one of the values that have been predefined for it.
Common examples include compass directions (values of NORTH, SOUTH, EAST, and WEST)

Decided to use this instead of having a switch or if/else
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
        throw new RuntimeException("Please enter a valid value for direction. "+inputValue+" is not within the possible list of directions");
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
