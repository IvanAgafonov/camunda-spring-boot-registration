package org.registration.entity;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.registration.model.Record;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecordInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int clientId;

    private Record.StatusEnum status;

    public RecordInfo() {
    }

    public RecordInfo(int id, int clientId, Record.StatusEnum status) {
        this.id = id;
        this.clientId = clientId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "RecordInfo{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Record.StatusEnum getStatus() {
        return status;
    }
}
