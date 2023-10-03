package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "First name is required") val firstName: String,
    @field:NotEmpty(message = "Last name is required") val lastName: String,
    @field:CPF(message = "CPF is invalid") val cpf: String,
    @field:NotNull(message = "Income is required") val income: BigDecimal,
    @field:NotEmpty(message = "Email is required") @field:Email(message = "Email is invalid") val email: String,
    @field:NotEmpty(message = "Password is required") val password: String,
    @field:NotEmpty(message = "Zipcode is required") val zipcode: String,
    @field:NotEmpty(message = "Street is required") val street: String
) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipcode,
            street = this.street
        )
    )

}
