package com.streetfood.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.streetfood.pojo.Product;
import com.streetfood.repository.interfaces.ProductRepository;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Cloudinary cloudinary;
    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public void saveProduct(Product product) {
        try {
            //Upload img
            Map r = this.cloudinary.uploader().upload(product.getImg().getBytes(),
                    ObjectUtils.asMap("resouce_type", "auto"));

            //Lấy img lưu xuống csdl
            product.setImage((String) r.get("secure_url"));
            //Lưu vào repos
            this.productRepository.saveProduct(product);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Product getProduct(long id) {
        Optional<Product> opt = productRepository.getProducts().stream().filter(item -> item.getId() == id).findFirst();
        if (opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteProduct(id);
    }
}
