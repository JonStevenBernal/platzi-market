package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")  //Indica un mapeo de tipo spring
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),

    }) // Traduccion de objetos
    Category toCategory(Categoria categoria); // Convertir una categoaria en category

    // Casos Coversion
    @InheritInverseConfiguration // Indica un mapeo inverso
    @Mapping(target = "productos", ignore = true) // Ignoramos el mapping productos
    Categoria toCategoria(Category category);

}
