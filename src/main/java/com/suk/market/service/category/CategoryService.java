package com.suk.market.service.category;


import com.suk.market.domain.Category;

import java.util.Optional;

public interface CategoryService {
    Iterable<Category> findAllCategory();

    Optional<Category> findCategoryById(long id);

    void save(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(long id);
}
