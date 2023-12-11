package sem451;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReserveBlockList {

    private List<ReserveBlock> reserveBlocks;

//   Constructor to initialize the ReserveBlockList.
    public ReserveBlockList() {
        reserveBlocks = new ArrayList<>();
    }

  //     Adds a ReserveBlock to the list.

    public void addReserveBlock(ReserveBlock rb) {
        if (rb == null) {
            throw new IllegalArgumentException("ReserveBlock cannot be null.");
        }
        reserveBlocks.add(rb);
    }

    public boolean removeReserveBlock(ReserveBlock rb) {
        if (rb == null) {
            throw new IllegalArgumentException("ReserveBlock cannot be null.");
        }
        return reserveBlocks.remove(rb);
    }

    // Finds ReserveBlocks by a specific date.
  
    public List<ReserveBlock> findReserveBlocksByDate(LocalDate date) {
        return reserveBlocks.stream()
                .filter(rb -> rb.getDate().equals(date))
                .collect(Collectors.toList());
    }
// Finds dates for a specific reserved block.
  
    public List<LocalDate> findDatesForReservedBlock(ReserveBlock targetBlock) {
        if (targetBlock == null) {
            throw new IllegalArgumentException("Target block cannot be null.");
        }
        return reserveBlocks.stream()
                .filter(rb -> rb.equals(targetBlock))
                .map(ReserveBlock::getDate)
                .collect(Collectors.toList());
    }

// Gets all the ReserveBlocks.
  
    public List<ReserveBlock> getAllReserveBlocks() {
        return new ArrayList<>(reserveBlocks);
    }
}
