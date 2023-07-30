package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.ReportProjection;
import com.devsuperior.dsmeta.projections.SummaryProjection;


public interface SaleRepository extends JpaRepository<Sale, Long> {

	
    @Query(nativeQuery = true,
            value = "SELECT tb_sales.id, tb_sales.date, tb_sales.amount, tb_seller.name "
                    + "FROM tb_sales "
                    + "INNER JOIN tb_seller ON tb_seller.id = tb_sales.seller_id "
                    + "WHERE UPPER(tb_seller.name) LIKE CONCAT('%',UPPER(:name),'%') AND "
                    + "tb_sales.date BETWEEN :minDate AND :maxDate",
                    countQuery = "SELECT COUNT(*) FROM tb_sales INNER JOIN tb_seller ON tb_seller.id = tb_sales.seller_id "
                            + "WHERE UPPER(tb_seller.name) LIKE CONCAT('%',UPPER(:name),'%') AND "
                            + "tb_sales.date BETWEEN :minDate AND :maxDate")
    Page<ReportProjection> findReport(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);

    
    
    @Query(nativeQuery = true,
            value = "SELECT tb_seller.name, SUM(tb_sales.amount) AS salesAmount "
                    + "FROM tb_sales "
                    + "INNER JOIN tb_seller ON tb_seller.id = tb_sales.seller_id "
                    + "WHERE tb_sales.date BETWEEN :minDate AND :maxDate "
                    + "GROUP BY tb_seller.name")
    List<SummaryProjection> findSummary(LocalDate minDate, LocalDate maxDate);


  
}
