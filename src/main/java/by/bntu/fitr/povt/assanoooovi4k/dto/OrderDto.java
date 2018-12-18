package by.bntu.fitr.povt.assanoooovi4k.dto;

public class OrderDto {

    private String cardNumber;
    private String city;
    private String address;
    private Long itemId;

    public OrderDto() {
    }

    public OrderDto(String cardNumber, String city, String address, Long itemId) {
        this.cardNumber = cardNumber;
        this.city = city;
        this.address = address;
        this.itemId = itemId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
