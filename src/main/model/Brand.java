package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "brand")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
	private long id;
	
    @NotBlank(message = "{brand.description.notblank}")
    @Size(min = 2, message = "{brand.description.size}")
    @Column(name = "brand_description", length = 20)
    private String brandDescription;
	
    /*
     * uncomment if you want to have a bidirectional mapping
     * 
     * @OneToOne(mappedBy = "product") private Product product;
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

}
