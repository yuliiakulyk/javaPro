import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Yuliia Kulyk on 28.05.2018.
 */
@Entity
public class ExchangeRate {

    @Id
    @GeneratedValue
    private Long id;
    private Double uahForUsd;
    private Double uahForEur;

    public ExchangeRate(Double uahForUsd, Double uahForEur) {
        this.uahForUsd = uahForUsd;
        this.uahForEur = uahForEur;
    }

    public ExchangeRate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getUahForUsd() {
        return uahForUsd;
    }

    public void setUahForUsd(Double uahForUsd) {
        this.uahForUsd = uahForUsd;
    }

    public Double getUahForEur() {
        return uahForEur;
    }

    public void setUahForEur(Double uahForEur) {
        this.uahForEur = uahForEur;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id=" + id +
                ", uahForUsd=" + uahForUsd +
                ", uahForEur=" + uahForEur +
                '}';
    }
}
