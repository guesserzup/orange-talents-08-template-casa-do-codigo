package br.com.zupacademy.gabriel.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import org.springframework.util.Assert;
import javax.validation.ConstraintValidator;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue,Object> {

    private Class<?> klass;
    private String domainAttribute;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+" = :value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        //Assert.state(list.size() >= 1, "Foi encontrado mais de um "+klass+" com o atributo "+domainAttribute+" = "+value);
        return list.isEmpty();
    }
}
