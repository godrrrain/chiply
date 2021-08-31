package com.example.chiply.domain.model

/*
Модель для создания заказов
 */

data class CreateOrderModel(

    var firstName: String = "",

    var secondName: String = "",

    var thirdName: String = "",

    var phone: String = ""
)