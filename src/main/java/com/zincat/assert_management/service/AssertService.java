package com.zincat.assert_management.service;

import com.zincat.assert_management.dto.request.AssertRequestDTO;
import com.zincat.assert_management.dto.response.AssertResponseDTO;

import java.util.List;

public interface AssertService {
    String saveAsserts(AssertRequestDTO assertRequestDTO);

    List<AssertResponseDTO> getAllAsserts();

    String updateAssert(int id, AssertRequestDTO assertRequestDTO);

    String deleteAssertById(int id);
}
