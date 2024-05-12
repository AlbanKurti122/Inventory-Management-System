package Validator;

import Dto.ProductDto;

public class ProductValidator {
     public static void validateProduct(ProductDto productDto){
          if(productDto.getModel().isEmpty()){
               throw new IllegalArgumentException("Ju lutem modeli i produktit eshte i nevojshem");
          }
          if (productDto.getPrice() <=0.0){
              throw new IllegalArgumentException("Cmimi i produktit nuk mund te jet 0 ose me vlera negative");
          }
     }
}