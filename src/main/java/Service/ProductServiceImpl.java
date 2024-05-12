package Service;

import Config.HibernateConfig;
import Converter.ProductConverter;
import Entity.Product;
import Dao.ProductDao;
import Dao.ProductDaoImpl;
import Dto.ProductDto;
import Validator.ProductValidator;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private final Integer quantity = 5;
    private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory() ;

    @Override
    public void createProduct(ProductDto productDto) {
        ProductValidator.validateProduct(productDto);
        Product product = ProductConverter
                .convertToEntity(productDto);

        ProductDao productDao = new ProductDaoImpl(sessionFactory);
        productDao.save(product);

    }

    @Override
    public List<Product> displayAllProducts() {
        ProductDao productDao = new ProductDaoImpl(sessionFactory);
        return productDao.findAll();
    }

    @Override
    public List<Product> notifyLowStock() {
        ProductDao productDao = new ProductDaoImpl(sessionFactory);
        return productDao.findLowStockProducts(quantity);
    }
}