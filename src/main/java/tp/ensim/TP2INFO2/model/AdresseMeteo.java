package tp.ensim.TP2INFO2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdresseMeteo {
    @Id
    @GeneratedValue
    private Long id;
    private Date creation;
    private String address;
    private String sunHours;
    private String probarain;
    private String wind10m;
    private String tmin;
    private String tmax;
}
