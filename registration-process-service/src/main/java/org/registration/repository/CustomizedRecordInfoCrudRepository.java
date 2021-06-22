package org.registration.repository;

import org.registration.entity.RecordInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomizedRecordInfoCrudRepository extends CrudRepository<RecordInfo, Long> {
    List<RecordInfo> findAll();
}
