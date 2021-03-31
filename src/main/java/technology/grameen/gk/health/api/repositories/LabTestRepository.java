package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.LabTest;
import technology.grameen.gk.health.api.projection.LabTestListItem;


import java.util.List;


@Repository
public interface LabTestRepository extends JpaRepository<LabTest,Long> {

    @Query(value = "SELECT lt.id, p.FULL_NAME AS fullName , p.PID as pid , pi2.INVOICE_NUMBER AS invoiceNumber," +
            " lt.CREATED_AT AS createdAt FROM  LAB_TESTS lt INNER JOIN PATIENTS p ON p.id = lt.PATIENT_ID \n" +
            "INNER JOIN PATIENT_INVOICES pi2 ON pi2.id = lt.PATIENT_INVOICE_ID ", nativeQuery=true)
    List<LabTestListItem> getLabTests();

}
