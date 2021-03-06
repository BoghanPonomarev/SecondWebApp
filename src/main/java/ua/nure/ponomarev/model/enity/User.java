package ua.nure.ponomarev.model.enity;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Bogdan_Ponamarev.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "user")
@Component
@Scope("prototype")
@NamedQueries({
        @NamedQuery(name = "User.getAll", query = "FROM User"),

})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Email(message = "Email has incorrect format")
    @NotNull(message = "Email ca`nt be empty")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Pattern(regexp = "\\d{9,11}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", message = "Phone number is invalid")
    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @NotNull(message = "Phone number ca`nt be empty")
    @NotEmpty(message = "Phone number ca`nt be empty")
    @Pattern(regexp = "\\w+",message = "Only symbols and numbers")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "password_salt",nullable = true)
    private String salt;

    @Past
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "dd:MM:yyyy")
    private Calendar dateOfBirth;

    @Enumerated(value = EnumType.ORDINAL)
    private Role role;

}
