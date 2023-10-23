package Turkcellbootcamp.Springstart.entities.dtos.OrderDtos;



import Turkcellbootcamp.Springstart.entities.dtos.OrderDetailDtos.OrderDetailForAddDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data

@RequiredArgsConstructor

public class OrderForAddDto {

    private LocalDate orderDate;
    private LocalDate shippedDate;
    private float freight;
    private String shipName;
    @NotBlank(message = "Adres alanı girmek zorunludur.")
    private String shipAddress;
    @NotBlank(message = "Şehir adı yazmak zorunludur.")
    private String shipCity;
    private String customerId;
    private short employeeId;
    private String shipCountry;
    private String shipRegion;
    private String shipPostalCode;
    private short shipperId;
    private LocalDate requiredDate;

    private List<OrderDetailForAddDto>items;
}
