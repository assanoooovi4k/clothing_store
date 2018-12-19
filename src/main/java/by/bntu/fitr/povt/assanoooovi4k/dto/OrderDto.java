package by.bntu.fitr.povt.assanoooovi4k.dto;

public class OrderDto {

    private String cardNumber;
    private String address;
    private Long itemId;

    public OrderDto() {
    }

    public OrderDto(String cardNumber, String address, Long itemId) {
        this.cardNumber = cardNumber;
        this.address = address;
        this.itemId = itemId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
