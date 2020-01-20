package com.gcs.deoxys.types;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "TempProcessRequestDTO")
@Table(name = "processed_transactions")
@NamedQuery(name = "lastProcessedTransaction", query = "SELECT tpr " +
                                                       "FROM TempProcessRequestDTO tpr " +
                                                       "WHERE tpr.gcs_sequence_number = " +
                                                                "(SELECT MAX(itpr.gcs_sequence_number) " +
                                                                "FROM TempProcessRequestDTO itpr)")
public class TempProcessRequestDTO {

    @Id
    @Column(name = "gcs_sequence_number")
    private int gcs_sequence_number;

    @Column(name = "process_date")
    private Date processDate;

    @Column(name = "request_id")
    private String requestId;

    public TempProcessRequestDTO(TransactionRequestDTO transactionRequestDTO) {

        this.setGcs_sequence_number(transactionRequestDTO.getGcsSequenceNo());
        this.setProcessDate(new Date());
        this.setRequestId(transactionRequestDTO.getAuthorizationNumber());

    }

    public TempProcessRequestDTO() {

    }

    public int getGcs_sequence_number() {
        return gcs_sequence_number;
    }

    public void setGcs_sequence_number(int gcs_sequence_number) {
        this.gcs_sequence_number = gcs_sequence_number;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
