package com.microstar.cms.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@Table(name="COMPLAINT_TBL")
public class Complaint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long caseNo;
    @Column(name="complaint_date", nullable = false)
    private Date complaintDate;
    @ManyToOne
    @Column(name="customer_id", nullable = false)
    private User customerId;
    @ManyToOne
    @Column(nullable = false)
    private Category category;
    @Column(name="complaint_details", nullable = false)
    private String complaintDetails;
    @Column(name="case_status", nullable = false)
    private ServiceStatus caseStatus;
    @ManyToOne
    @Column(name="technician_id")
    private User staffId;
    @Column(name="solution_details")
    private String resolutionDetails;
    @Column(name="resolve_date")
    private Date resolveDate;

    public enum ServiceStatus {
        CLOSE,
        OPEN
    }

    public Complaint(Date complaintDate, User customerId, Category category, String complaintDetails, ServiceStatus caseStatus) {
        this.complaintDate = complaintDate;
        this.customerId = customerId;
        this.category = category;
        this.complaintDetails = complaintDetails;
        this.caseStatus = caseStatus;
    }


}
