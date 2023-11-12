package org.memorygame.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "gamescores")
public class GameScore {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private Long gamer_id;
    private int score;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private CellState cellState;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private List<CellState> cellStates = new ArrayList<>();

    public GameScore(Long gamer_id, int score, CellState cellState, List<CellState> cellStates) {
        this.gamer_id = gamer_id;
        this.score = score;
        this.cellState = cellState;
        this.cellStates = cellStates;
    }
}
