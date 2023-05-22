package com.swifties.bahceden.models;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Category {
    private static List<Category> existingCategories;

    private int id;
    private String name;

    private Category () {};
    private Category (int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public static Category newCategory (int id, String name)
    {
        Optional<Category> optionalCategory = existingCategories.stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            if (!category.getName().equals(name)) {
                throw new RuntimeException("category id's match but names aren't!");
            }
            return category;
        }

        Category category = new Category(id, name);
        existingCategories.add(category);
        return category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
