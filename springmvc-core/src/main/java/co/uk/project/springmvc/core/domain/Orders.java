package co.uk.project.springmvc.core.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Kannan Gnanasigamani
 */
@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
        @NamedQuery(name = "Orders.findByOrderNumber", query = "SELECT o FROM Orders o WHERE o.orderNumber = :orderNumber"),
        @NamedQuery(name = "Orders.findByCustomerId", query = "SELECT o FROM Orders o WHERE o.orderNumber = :orderNumber"),
        @NamedQuery(name = "Orders.findBySalePrice", query = "SELECT o FROM Orders o WHERE o.salePrice = :salePrice"),
        @NamedQuery(name = "Orders.findByDeposit", query = "SELECT o FROM Orders o WHERE o.deposit = :deposit"),
        @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate")})
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_number")
    private Integer orderNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "sale_price")
    private BigDecimal salePrice;
    @Basic(optional = false)
    @Column(name = "deposit")
    private BigDecimal deposit;
    @Basic(optional = false)
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @JoinColumn(name = "customer_number", referencedColumnName = "customer_number")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customers customerNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderNumber", fetch = FetchType.LAZY)
    private List<OrderedVehicles> orderedVehiclesList;

    public Orders() {
    }

    public Orders(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Orders(Integer orderNumber, BigDecimal salePrice, BigDecimal deposit, Date orderDate) {
        this.orderNumber = orderNumber;
        this.salePrice = salePrice;
        this.deposit = deposit;
        this.orderDate = orderDate;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customers getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Customers customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<OrderedVehicles> getOrderedVehiclesList() {
        return orderedVehiclesList;
    }

    public void setOrderedVehiclesList(List<OrderedVehicles> orderedVehiclesList) {
        this.orderedVehiclesList = orderedVehiclesList;
    }

    public int hashcode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
