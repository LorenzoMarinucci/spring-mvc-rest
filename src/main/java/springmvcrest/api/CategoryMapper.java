package springmvcrest.api;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springmvcrest.api.model.CategoryDTO;
import springmvcrest.domain.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
