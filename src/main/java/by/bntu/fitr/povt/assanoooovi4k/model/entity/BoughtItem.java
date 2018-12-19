package by.bntu.fitr.povt.assanoooovi4k.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class BoughtItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;

    @OneToOne(targetEntity = Item.class, fetch = FetchType.EAGER)
    private Item item;

    private String status;

    private Integer cardNumber;

    private String address;

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BoughtItem() {
    }

    public BoughtItem(User user, Item item, String status) {
        this.user = user;
        this.item = item;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoughtItem that = (BoughtItem) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(item, that.item) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, item, status);
    }

    @Override
    public String toString() {
        return "BoughtItem{" +
                "id=" + id +
                ", user=" + user +
                ", item=" + item +
                ", status='" + status + '\'' +
                '}';
    }
}
