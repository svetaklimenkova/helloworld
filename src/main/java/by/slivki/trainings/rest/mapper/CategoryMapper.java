package by.slivki.trainings.rest.mapper;

import by.slivki.trainings.dao.jpa.Category;
import by.slivki.trainings.rest.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public List<CategoryDto> toCategoryDtos(List<Category> categories) {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        if (categories != null) {
            for (Category category : categories) {
                categoryDtos.add(toCategoryDto(category));
            }
        }
        return categoryDtos;
    }

    public CategoryDto toCategoryDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }
}
