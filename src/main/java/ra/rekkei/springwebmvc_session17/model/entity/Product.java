package ra.rekkei.springwebmvc_session17.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class Product {
    private Integer proId;
    @NotBlank(message = "Product name is empty!")
    private String proName;
    @NotBlank(message = "Producer is empty!")
    private String producer;
    @NotNull(message = "Year making is empty!")
    private Integer yearMaking;
    @NotNull(message = "Expire date is empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date is not valid")
    private Date expireDate;
    @NotNull(message = "Price is empty!")
    @Min(value = 0,message = "Price must be positive number")
    private Double price;
    @NotBlank(message = "Unit price is empty!")
    private String unitPrice;
    @NotBlank(message = "Color is empty!")
    private String color;
    private String imageName;

    public Product() {
    }

    public Product(Integer proId, String proName, String producer, Integer yearMaking, Date expireDate, Double price, String unitPrice, String color, String imageName) {
        this.proId = proId;
        this.proName = proName;
        this.producer = producer;
        this.yearMaking = yearMaking;
        this.expireDate = expireDate;
        this.price = price;
        this.unitPrice = unitPrice;
        this.color = color;
        this.imageName = imageName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(Integer yearMaking) {
        this.yearMaking = yearMaking;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
