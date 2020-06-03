package lk.J_N_Super_Pvt_Ltd.asset.supplier.dao;


import lk.J_N_Super_Pvt_Ltd.asset.supplier.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer> {
    Supplier findFirstByOrderByIdDesc();
}
