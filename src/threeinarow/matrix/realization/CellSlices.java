package threeinarow.matrix.realization;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class CellSlices{

    private HashMap<Coordinate, CellSlice> sliceHashMap;

    public CellSlices() {
        this.sliceHashMap = new HashMap<>();
    }


    public CellSlice getByCoordinate(Coordinate c) {
        return sliceHashMap.get(c);
    }

    //for streams TODO
    public Collection<CellSlice> getSlices() {
        return sliceHashMap.values();
    }

    public void addSlice(Coordinate coordinate, CellSlice slice) {
        sliceHashMap.put(coordinate, slice);
    }
}
