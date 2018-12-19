package by.bntu.fitr.povt.assanoooovi4k.dto;

public class OrderDto {

    private Integer cardNumber;
    private String address;
    private Long itemId;

    public OrderDto() {
    }

    public OrderDto(Integer cardNumber, String address, Long itemId) {
        this.cardNumber = cardNumber;
        this.address = address;
        this.itemId = itemId;
    }

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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
