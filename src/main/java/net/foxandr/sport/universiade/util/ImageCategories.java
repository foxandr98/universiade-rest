package net.foxandr.sport.universiade.util;

public enum ImageCategories {
    LOST_FOUND_REQUEST(1),
    LOST_FOUND_DETECTED(2),
    NEWS (3);

    private final long number;
    private ImageCategories(long number){
        this.number = number;
    }

    public long getNumber(){
        return number;
    }
}
