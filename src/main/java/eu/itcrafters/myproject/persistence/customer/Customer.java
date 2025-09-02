package eu.itcrafters.myproject.persistence.customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 20)
    @NotNull
    @Column(name = "FIRST_NAME", nullable = false, length = 20)
    private String firstName;

    @Size(max = 20)
    @NotNull
    @Column(name = "LAST_NAME", nullable = false, length = 20)
    private String lastName;

}