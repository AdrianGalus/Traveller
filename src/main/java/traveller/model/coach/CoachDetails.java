package traveller.model.coach;

import javax.persistence.*;

@Entity
@Table(name = "coaches_details")
public class CoachDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private String model;
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Coach coach;

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getMark() {

        return mark;
    }
    public void setMark(String mark) {

        this.mark = mark;
    }
    public String getModel() {

        return model;
    }
    public void setModel(String model) {

        this.model = model;
    }
    public Coach getCoach() {

        return coach;
    }
    public void setCoach(Coach coach) {

        this.coach = coach;
    }
}
