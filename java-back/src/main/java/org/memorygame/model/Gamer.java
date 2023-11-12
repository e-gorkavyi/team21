package org.memorygame.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "gamers")
public class Gamer {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private String name;

    public Gamer(String name) {
        this.name = name;
    }
}
