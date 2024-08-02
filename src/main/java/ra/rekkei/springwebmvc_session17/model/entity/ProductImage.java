package ra.rekkei.springwebmvc_session17.model.entity;

public class ProductImage {
    private Integer imageId;
    private Integer proId;
    private String imageName;

    public ProductImage() {
    }

    public ProductImage(Integer imageId, Integer proId, String imageName) {
        this.imageId = imageId;
        this.proId = proId;
        this.imageName = imageName;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
