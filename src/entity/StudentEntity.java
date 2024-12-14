package entity;

import entity.embedded.StudentName;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nic", nullable = false)
    private String nic;
    // Composite Attribute
    private StudentName name;

    // Multi Valued Attribute
    @ElementCollection
    @CollectionTable(
            name = "student_mobile",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private List<String> mobiles;

    //CreationDate
    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Date createDate;
}
