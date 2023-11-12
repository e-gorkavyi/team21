package org.memorygame.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "gamescores")
public class GameState {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private Long gamer_id;
    private int score;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "cellImages", joinColumns = @JoinColumn(name = "gamescore_id"))
    @Column(name = "cellImage", nullable = false)
    private List<String> cellImages;

    public GameState(Long gamer_id, int score, List<String> cellImages) {
        this.gamer_id = gamer_id;
        this.score = score;
        this.cellImages = cellImages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGamer_id() {
        return gamer_id;
    }

    public void setGamer_id(Long gamer_id) {
        this.gamer_id = gamer_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getCellImages() {
        return cellImages;
    }

    public void setCellImages(List<List<String>> cellImages) {
        List<String> oneDArray = new ArrayList<>();
        for (List<String> row : cellImages) {
            oneDArray.addAll(row);
        }
        this.cellImages = oneDArray;
    }
}
