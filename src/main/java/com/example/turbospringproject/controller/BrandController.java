package com.example.turbospringproject.controller;

import com.example.turbospringproject.model.BrandDto;
import com.example.turbospringproject.model.BrandLiteDto;
import com.example.turbospringproject.service.BrandService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/brands")
@CrossOrigin
public class BrandController {
    private final BrandService brandsService;

    public BrandController(BrandService brandsService) {
        this.brandsService = brandsService;
    }

    @GetMapping
    public List<BrandLiteDto> getAllBrand() {
        return brandsService.getAllBrand();
    }

    @GetMapping("byId/{brandId}")
    public BrandDto getBrand(@PathVariable Integer brandId) {
        return brandsService.getBrand(brandId);
    }
    @GetMapping("byName/{brandName}")
    public BrandDto getBrandByName(@PathVariable String brandName){
        return brandsService.getBrandByName(brandName);
    }
    @PostMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public void saveBrand(@RequestBody BrandDto brandDto) {
        brandsService.saveBrand(brandDto);
    }

    @DeleteMapping("/admin/{brandId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBrand(@PathVariable Integer brandId) {
        brandsService.deleteBrand(brandId);
    }

}
