package th2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@NotBlank(message = "Code is required")
	private String code;

	@NotBlank(message = "Description is required")
	private String description;

	private double price;
}
