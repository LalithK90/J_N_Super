package lk.J_N_Super_Pvt_Ltd.asset.purchaseOrder.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.J_N_Super_Pvt_Ltd.asset.payment.entity.Payment;
import lk.J_N_Super_Pvt_Ltd.asset.purchaseOrder.entity.Enum.PurchaseOrderStatus;
import lk.J_N_Super_Pvt_Ltd.asset.supplier.entity.Supplier;
import lk.J_N_Super_Pvt_Ltd.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("PurchaseOrder")
public class PurchaseOrder extends AuditEntity {

    private String remark;

    @Column(nullable = false, unique = true)
    private String code;

    @Enumerated(EnumType.STRING)
    private PurchaseOrderStatus purchaseOrderStatus;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.PERSIST)
    private List<lk.J_N_Super_Pvt_Ltd.asset.purchaseOrder.entity.PurchaseOrderItem> purchaseOrderItems;

    @ManyToOne
    private Supplier supplier;

    @OneToMany(mappedBy = "purchaseOrder")
    private List<Payment> payments;
}
