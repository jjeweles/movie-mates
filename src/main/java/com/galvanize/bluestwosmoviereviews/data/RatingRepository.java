package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class RatingRepository implements JpaRepository<RatingModel, Integer> {
}
