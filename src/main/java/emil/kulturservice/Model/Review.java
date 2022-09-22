
package emil.kulturservice.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewTxt;
    private double rating;
    @ManyToOne
    @JsonBackReference
    private Event event;
    @ManyToOne
    @JsonBackReference
    private User user;
}
