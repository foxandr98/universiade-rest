package net.foxandr.sport.universiade.restapi.competitions.games.medals;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MedalsSummaryEntity {
    @Id
    @Column(name = "rank")
    private Long rank;

    @Column(name = "ioc_name")
    private String iocName;

    @Column(name = "name")
    private String name;

    @Column(name = "gold_count")
    private Integer goldCount;

    @Column(name = "silver_count")
    private Integer silverCount;

    @Column(name = "bronze_count")
    private Integer bronzeCount;

    @Column(name = "total")
    private Integer total;


    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public String getIocName() {
        return iocName;
    }

    public void setIocName(String iocName) {
        this.iocName = iocName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoldCount() {
        return goldCount;
    }

    public void setGoldCount(Integer goldCount) {
        this.goldCount = goldCount;
    }

    public Integer getSilverCount() {
        return silverCount;
    }

    public void setSilverCount(Integer silverCount) {
        this.silverCount = silverCount;
    }

    public Integer getBronzeCount() {
        return bronzeCount;
    }

    public void setBronzeCount(Integer bronzeCount) {
        this.bronzeCount = bronzeCount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedalsSummaryEntity that = (MedalsSummaryEntity) o;
        return Objects.equals(rank, that.rank) && Objects.equals(iocName, that.iocName) && Objects.equals(name, that.name) && Objects.equals(goldCount, that.goldCount) && Objects.equals(silverCount, that.silverCount) && Objects.equals(bronzeCount, that.bronzeCount) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, iocName, name, goldCount, silverCount, bronzeCount, total);
    }
}
