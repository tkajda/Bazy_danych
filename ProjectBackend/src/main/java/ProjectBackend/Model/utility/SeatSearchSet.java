package ProjectBackend.Model.utility;

import java.util.HashSet;
import java.util.Set;

public class SeatSearchSet {
    Set<Integer> seatNo;
    Integer numOfSeats;
    public SeatSearchSet(Integer numOfSeats){
        this.seatNo=new HashSet<Integer>();
        this.numOfSeats=numOfSeats;
    }
    public Integer getFirstUntaken(){
        for(int i=0;i<numOfSeats;i++){
            if(!this.seatNo.contains(i)){
                return i;
            }
        }
        return -1;
    }
    public void addTakenSeat(Integer takenSeatNo){
        this.seatNo.add(takenSeatNo);
    }
}
