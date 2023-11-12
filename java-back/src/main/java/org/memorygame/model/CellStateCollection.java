package org.memorygame.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "cellImages")
public class CellStateCollection {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

    public Long getId() {
        return id;
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "gamers", joinColumns = @JoinColumn(name = "gamer_id"))
    @Column(name = "cellImage", nullable = false)
    private List<String> cellImages;

    public CellStateCollection(List<String> cellImages) {
        this.cellImages = cellImages;
    }

    public List<List<CellState>> getCellImages() {
        int index;
        List<List<CellState>> result = new ArrayList<>();
        for (int i = 0; i < cellImages.size(); i = i + 4) {
            List<CellState> sublist = new ArrayList<>();
            for (int j = i; j < cellImages.size(); j++) {
                sublist.add(new CellState(cellImages.get(j).split(":", 1)[0], Boolean.parseBoolean(cellImages.get(j).split(":", 1)[1])));
            }
            result.add(sublist);
        }
        return result;
    }

    public void setCellImages(List<List<CellState>> cellImages) {
        List<String> oneDArray = new ArrayList<>();
        for (List<CellState> row : cellImages) {
            for (CellState cell : row) {
                oneDArray.add(cell.getName() + ":" + cell.getMatched().toString());
            }
        }
        this.cellImages = oneDArray;
    }
}
