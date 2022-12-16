package ge.ibsu.demo.entities;

import jakarta.persistence.*;


@Entity
@Table(name="address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_address_id_seq", sequenceName = "address_address_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "address_address_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name="address_id")
    private Long addressId;

    @Column(name="address")
    private String address;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
