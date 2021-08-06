package by.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    private Long id;
    private String name;
    private String film;
    private int age;

    public Actor(String name, String film, int age) {
        this.name = name;
        this.film = film;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", film='" + film + '\'' +
                ", age=" + age +
                '}';
    }
}
