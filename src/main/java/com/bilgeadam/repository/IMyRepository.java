package com.bilgeadam.repository;

import com.bilgeadam.entity.ComputerEntity;

import java.util.List;

public interface IMyRepository {

    public List<ComputerEntity> findComputerPriceMin(double minPrice);
}
