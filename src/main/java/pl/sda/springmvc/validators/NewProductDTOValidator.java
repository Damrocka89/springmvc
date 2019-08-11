package pl.sda.springmvc.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.sda.springmvc.dto.NewProductDTO;

@Component
public class NewProductDTOValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return NewProductDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NewProductDTO newProductDTO= (NewProductDTO) o;
        if (newProductDTO.getPrice()==null || newProductDTO.getPrice().longValue() < 0){
            errors.rejectValue("price", "product.validator.price.zero");
        }
    }
}
