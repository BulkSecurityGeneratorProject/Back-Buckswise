package com.valuequo.buckswise.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Others.
 */
@Entity
@Table(name = "others")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Others implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "handicapped")
    private String handicapped;

    @Column(name = "medicaltreat")
    private String medicaltreat;

    @Column(name = "selfedu")
    private String selfedu;

    @Column(name = "nps")
    private String nps;

    @Column(name = "rgess")
    private String rgess;

    @Column(name = "donation")
    private String donation;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public Others uid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getHandicapped() {
        return handicapped;
    }

    public Others handicapped(String handicapped) {
        this.handicapped = handicapped;
        return this;
    }

    public void setHandicapped(String handicapped) {
        this.handicapped = handicapped;
    }

    public String getMedicaltreat() {
        return medicaltreat;
    }

    public Others medicaltreat(String medicaltreat) {
        this.medicaltreat = medicaltreat;
        return this;
    }

    public void setMedicaltreat(String medicaltreat) {
        this.medicaltreat = medicaltreat;
    }

    public String getSelfedu() {
        return selfedu;
    }

    public Others selfedu(String selfedu) {
        this.selfedu = selfedu;
        return this;
    }

    public void setSelfedu(String selfedu) {
        this.selfedu = selfedu;
    }

    public String getNps() {
        return nps;
    }

    public Others nps(String nps) {
        this.nps = nps;
        return this;
    }

    public void setNps(String nps) {
        this.nps = nps;
    }

    public String getRgess() {
        return rgess;
    }

    public Others rgess(String rgess) {
        this.rgess = rgess;
        return this;
    }

    public void setRgess(String rgess) {
        this.rgess = rgess;
    }

    public String getDonation() {
        return donation;
    }

    public Others donation(String donation) {
        this.donation = donation;
        return this;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Others others = (Others) o;
        if (others.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), others.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Others{" +
            "id=" + getId() +
            ", uid=" + getUid() +
            ", handicapped='" + getHandicapped() + "'" +
            ", medicaltreat='" + getMedicaltreat() + "'" +
            ", selfedu='" + getSelfedu() + "'" +
            ", nps='" + getNps() + "'" +
            ", rgess='" + getRgess() + "'" +
            ", donation='" + getDonation() + "'" +
            "}";
    }
}
