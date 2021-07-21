package springmvcrest.services;

import springmvcrest.api.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);

}
