package com.streetfood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private long id;

    private String name;

    private String type;

    private BigDecimal price;

    private String image;
    private MultipartFile imgFile;

    private long categoryId;

}
